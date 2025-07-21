package org.atyeti.trafficManagement.api;

import org.atyeti.trafficManagement.dto.TrafficstateResponse;
import org.atyeti.trafficManagement.model.TrafficEvent;
import org.atyeti.trafficManagement.model.TrafficState;
import org.atyeti.trafficManagement.service.TrafficService;
import org.atyeti.trafficManagement.repository.TrafficEventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficRestController {

    private final TrafficService trafficService;
    private final TrafficEventRepository repo;

    public TrafficRestController(TrafficService trafficService, TrafficEventRepository repo) {
        this.trafficService = trafficService;
        this.repo = repo;
    }

    @PostMapping("/density")
    public ResponseEntity<String> updateDensity(
            @RequestParam String direction,
            @RequestParam String level) {
        trafficService.updateDensity(direction, level);
        return ResponseEntity.ok("Traffic density updated.");
    }

    @PostMapping("/emergency")
    public ResponseEntity<String> reportEmergency(@RequestParam String direction) {
        trafficService.reportEmergency(direction);
        return ResponseEntity.ok("Emergency reported.");
    }

    @GetMapping("/state")
    public ResponseEntity<TrafficstateResponse> getState() {
        TrafficState state = trafficService.getState();
        TrafficstateResponse dto = new TrafficstateResponse(
                state.getCurrentGreen(),
                state.getEmergencyDirection(),
                new HashMap<>(state.getTrafficDensity())
        );
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<TrafficEvent> getAllEvents() {
        return repo.findAll();
    }
}
