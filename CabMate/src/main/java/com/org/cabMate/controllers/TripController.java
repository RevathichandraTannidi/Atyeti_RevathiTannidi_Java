package com.org.cabMate.controllers;

import com.org.cabMate.dto.TripDTO;
import com.org.cabMate.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/request")
    public TripDTO requestTrip(@RequestParam Long riderId,
                               @RequestParam Long driverId,
                               @RequestParam double distanceKm) {
        return new TripDTO(tripService.requestTrip(riderId, driverId, distanceKm));
    }

    @PostMapping("/{tripId}/start")
    public TripDTO startTrip(@PathVariable Long tripId) {
        return new TripDTO(tripService.startTrip(tripId));
    }

    @PostMapping("/{tripId}/complete")
    public TripDTO completeTrip(@PathVariable Long tripId) {
        return new TripDTO(tripService.completeTrip(tripId));
    }

    @PostMapping("/{tripId}/cancel")
    public TripDTO cancelTrip(@PathVariable Long tripId) {
        return new TripDTO(tripService.cancelTrip(tripId));
    }

    @GetMapping
    public List<TripDTO> getAllTrips() {
        return tripService.getAllTrips()
                .stream()
                .map(TripDTO::new)
                .toList();
    }

    @GetMapping("/rider/{riderId}")
    public List<TripDTO> getRiderHistory(@PathVariable Long riderId) {
        return tripService.getRiderHistory(riderId)
                .stream()
                .map(TripDTO::new)
                .toList();
    }

    @GetMapping("/driver/{driverId}")
    public List<TripDTO> getDriverHistory(@PathVariable Long driverId) {
        return tripService.getDriverHistory(driverId)
                .stream()
                .map(TripDTO::new)
                .toList();
    }
}
