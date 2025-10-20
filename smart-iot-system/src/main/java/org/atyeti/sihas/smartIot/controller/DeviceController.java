package org.atyeti.sihas.smartIot.controller;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.dto.request.DeviceRequest;
import org.atyeti.sihas.smartIot.dto.response.DeviceResponse;
import org.atyeti.sihas.smartIot.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<DeviceResponse> register(@RequestBody DeviceRequest req) {
        return ResponseEntity.ok(deviceService.register(req));
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponse>> list() {
        return ResponseEntity.ok(deviceService.listAll());
    }

    @PostMapping("/control/{deviceId}")
    public ResponseEntity<String> control(@PathVariable String deviceId, @RequestParam String command) {
        deviceService.sendCommand(deviceId, command);
        return ResponseEntity.ok("Command sent");
    }
}
