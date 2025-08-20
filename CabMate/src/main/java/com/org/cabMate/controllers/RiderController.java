package com.org.cabMate.controllers;

import com.org.cabMate.dto.RiderDTO;
import com.org.cabMate.model.Rider;
import com.org.cabMate.service.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/riders")
public class RiderController {
    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping
    public RiderDTO registerRider(@RequestBody Rider rider) {
        return new RiderDTO(riderService.registerRider(rider));
    }

    @GetMapping
    public List<RiderDTO> getAllRiders() {
        return riderService.getAllRiders()
                .stream()
                .map(RiderDTO::new)
                .toList();
    }

    @PutMapping("/{id}/location")
    public RiderDTO updateLocation(@PathVariable Long id,
                                   @RequestParam double lat,
                                   @RequestParam double lon) {
        return new RiderDTO(riderService.updateRiderLocation(id, lat, lon));
    }
}
