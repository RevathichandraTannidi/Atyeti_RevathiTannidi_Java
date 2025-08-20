package com.org.cabMate.service;

import com.org.cabMate.model.Driver;
import com.org.cabMate.dao.DriverRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> getAvailableDrivers() {
        return driverRepository.findByAvailableTrue();
    }

    public Driver updateDriverLocation(Long driverId, double lat, double lon) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setLatitude(lat);
        driver.setLongitude(lon);
        return driverRepository.save(driver);
    }

    public void updateDriverAvailability(Long driverId, boolean available) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        driver.setAvailable(available);
        driverRepository.save(driver);
    }

    public Driver rateDriver(Long driverId, int stars) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driver.addRating(stars);
        return driverRepository.save(driver);
    }
}
