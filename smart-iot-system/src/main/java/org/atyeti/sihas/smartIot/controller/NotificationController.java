package org.atyeti.sihas.smartIot.controller;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.entity.Notification;
import org.atyeti.sihas.smartIot.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService svc;

    @GetMapping("/{username}")
    public ResponseEntity<List<Notification>> list(@PathVariable String username) {
        return ResponseEntity.ok(svc.forUser(username));
    }
}
