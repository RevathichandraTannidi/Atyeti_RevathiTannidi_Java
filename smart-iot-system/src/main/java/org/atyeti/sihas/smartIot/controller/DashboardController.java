package org.atyeti.sihas.smartIot.controller;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.repository.DeviceLogRepository;
import org.atyeti.sihas.smartIot.repository.DeviceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DeviceLogRepository deviceLogRepo;
    private final DeviceRepository deviceRepo;

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> summary() {
        long totalDevices = deviceRepo.count();
        long totalLogs = deviceLogRepo.count();
        return ResponseEntity.ok(Map.of("totalDevices", totalDevices, "totalLogs", totalLogs));
    }
}
