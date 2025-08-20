package com.org.cabMate.controllers;

import com.org.cabMate.dto.DriverDTO;
import com.org.cabMate.model.Driver;
import com.org.cabMate.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public DriverDTO registerDriver(@RequestBody Driver driver) {
        return new DriverDTO(driverService.registerDriver(driver));
    }

    @GetMapping
    public List<DriverDTO> getAllDrivers() {
        return driverService.getAllDrivers()
                .stream()
                .map(DriverDTO::new)
                .toList();
    }

    @PostMapping("/{id}/rate")
    public DriverDTO rateDriver(@PathVariable Long id, @RequestParam int stars) {
        return new DriverDTO(driverService.rateDriver(id, stars));
    }

    @GetMapping("/available")
    public List<DriverDTO> getAvailableDrivers() {
        return driverService.getAvailableDrivers()
                .stream()
                .map(DriverDTO::new)
                .toList();
    }

    @PutMapping("/{id}/location")
    public DriverDTO updateDriverLocation(@PathVariable Long id,
                                          @RequestParam double lat,
                                          @RequestParam double lon) {
        return new DriverDTO(driverService.updateDriverLocation(id, lat, lon));
    }

    @PutMapping("/{id}/availability")
    public void updateDriverAvailability(@PathVariable Long id,
                                         @RequestParam boolean available) {
        driverService.updateDriverAvailability(id, available);
    }
}
