package org.atyeti.sihas.smartIot.service;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.dto.request.RoomRequest;
import org.atyeti.sihas.smartIot.entity.Room;
import org.atyeti.sihas.smartIot.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepo;

    public Room create(RoomRequest req) {
        Room r = Room.builder().name(req.getName()).type(req.getType()).build();
        return roomRepo.save(r);
    }

    public List<Room> list() {
        return roomRepo.findAll();
    }
}

