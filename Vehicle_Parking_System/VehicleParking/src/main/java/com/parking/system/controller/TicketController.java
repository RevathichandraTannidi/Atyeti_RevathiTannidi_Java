package com.parking.system.controller;

import com.parking.system.dto.*;
import com.parking.system.exception.ResourceNotFoundException;
import com.parking.system.model.*;
import com.parking.system.repository.ParkingFloorRepository;
import com.parking.system.repository.ParkingSlotRepository;
import com.parking.system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ParkingSlotRepository slotRepository;

    @Autowired
    private ParkingFloorRepository floorRepository;

    // Get all slots
    @GetMapping("/slots")
    public ResponseEntity<List<ParkingSlot>> getAllSlots() {
        return ResponseEntity.ok(slotRepository.findAll());
    }

    // Vehicle entry (ticket creation)
    @PostMapping("/entry")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequestDto requestDTO) throws Exception {
        return ResponseEntity.ok(ticketService.createTicket(requestDTO));
    }

    // Vehicle exit (ticket closing)
    @PostMapping("/exit/{ticketId}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable Long ticketId) throws ResourceNotFoundException {
        return ResponseEntity.ok(ticketService.closeTicket(ticketId));
    }

    // Reserve specific slot
    @PostMapping("/slots/reserve")
    public ResponseEntity<String> reserveSlot(@RequestParam Long slotId, @RequestParam String vehicleNumber) throws ResourceNotFoundException {
        ParkingSlot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new ResourceNotFoundException("Slot not found with id: " + slotId));

        if (!slot.getIsAvailable()) {
            return ResponseEntity.badRequest().body("Slot is not available.");
        }

        slot.setIsReserved(true);
        slot.setReservedForVehicleNumber(vehicleNumber);
        slotRepository.save(slot);
        return ResponseEntity.ok("Slot reserved successfully for vehicle " + vehicleNumber);
    }

    // Get ticket details
    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketDto> getTicketDetails(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ticketService.getTicketDetails(id));
    }

    // Create full parking lot structure with floors and slots
    @PostMapping("/lot")
    public ResponseEntity<String> createFullLotStructure(@RequestBody ParkingSlotDto lotDto) {
        for (ParkingFloorDto floorDto : lotDto.getFloors()) {
            ParkingFloor floor = new ParkingFloor();
            floor.setFloorNumber(floorDto.getFloorNumber());

            List<ParkingSlot> slots = new ArrayList<>();
            for (ParkingLotDto slotDto : floorDto.getSlots()) {
                ParkingSlot slot = new ParkingSlot();
                slot.setSlotNumber(slotDto.getSlotNumber());
                slot.setSlotType(SlotType.valueOf(slotDto.getSlotType()));

                slot.setIsAvailable(slotDto.getAvailable() != null ? slotDto.getAvailable() : true);
                slot.setIsReserved(slotDto.getReserved() != null ? slotDto.getReserved() : false);

                slot.setReservedForVehicleNumber(slotDto.getReservedForVehicleNumber());

                slot.setFloor(floor);
                slots.add(slot);
            }

            floor.setSlots(slots);
            floorRepository.save(floor);
            slotRepository.saveAll(slots);
        }

        return ResponseEntity.ok("Parking Lot with floors and slots created successfully.");
    }
}
