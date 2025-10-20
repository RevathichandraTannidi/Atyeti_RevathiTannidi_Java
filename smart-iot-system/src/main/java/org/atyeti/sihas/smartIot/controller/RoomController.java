package org.atyeti.sihas.smartIot.controller;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.dto.request.RoomRequest;
import org.atyeti.sihas.smartIot.entity.Room;
import org.atyeti.sihas.smartIot.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody RoomRequest req) {
        return ResponseEntity.ok(roomService.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Room>> list() {
        return ResponseEntity.ok(roomService.list());
    }
}

