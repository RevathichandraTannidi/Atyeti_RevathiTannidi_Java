package com.org.cabMate.service;

import com.org.cabMate.model.*;
import com.org.cabMate.dao.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;

    public TripService(TripRepository tripRepository, DriverRepository driverRepository,
                       RiderRepository riderRepository) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
    }

    public Trip requestTrip(Long riderId, Long driverId, double distanceKm) {
        Rider rider = riderRepository.findById(riderId)
                .orElseThrow(() -> new RuntimeException("Rider not found"));
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        if (!driver.isAvailable()) {
            throw new RuntimeException("Driver not available");
        }

        double surgeMultiplier = calculateSurge();
        double fare = calculateFare(distanceKm, surgeMultiplier);

        Trip trip = new Trip(null, rider, driver, distanceKm, fare, surgeMultiplier,
                RideStatus.REQUESTED, Instant.now(), null, null);

        driver.setAvailable(false);
        driverRepository.save(driver);

        return tripRepository.save(trip);
    }

    public Trip startTrip(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setStatus(RideStatus.ONGOING);
        trip.setStartedAt(Instant.now());
        return tripRepository.save(trip);
    }

    public Trip completeTrip(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setStatus(RideStatus.COMPLETED);
        trip.setCompletedAt(Instant.now());

        Driver driver = trip.getDriver();
        driver.setAvailable(true);
        driverRepository.save(driver);

        return tripRepository.save(trip);
    }

    public Trip cancelTrip(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        trip.setStatus(RideStatus.CANCELLED);

        Driver driver = trip.getDriver();
        driver.setAvailable(true);
        driverRepository.save(driver);

        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getRiderHistory(Long riderId) {
        return tripRepository.findByRiderId(riderId);
    }

    public List<Trip> getDriverHistory(Long driverId) {
        return tripRepository.findByDriverId(driverId);
    }

    private double calculateFare(double distanceKm, double surgeMultiplier) {
        double baseFare = 50;
        double perKmRate = 12;
        return (baseFare + (distanceKm * perKmRate)) * surgeMultiplier;
    }

    private double calculateSurge() {
        long activeTrips = tripRepository.findByStatus(RideStatus.ONGOING).size();
        long availableDrivers = driverRepository.findByAvailableTrue().size();

        if (availableDrivers == 0) return 3.0;
        double demandSupplyRatio = (double) activeTrips / availableDrivers;

        if (demandSupplyRatio > 2) return 2.0;
        else if (demandSupplyRatio > 1) return 1.5;
        else return 1.0;
    }
}
