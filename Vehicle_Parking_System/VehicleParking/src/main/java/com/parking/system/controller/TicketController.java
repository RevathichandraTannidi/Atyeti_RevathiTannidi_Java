package com.parking.system.controller;

import com.parking.system.dto.TicketDto;
import com.parking.system.dto.TicketRequestDto;
import com.parking.system.exceptionHandling.ResourceNotFoundException;
import com.parking.system.model.ParkingSlot;
import com.parking.system.model.Ticket;
import com.parking.system.repository.ParkingSlotRepository;
import com.parking.system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ParkingSlotRepository slotRepository;
    @PostMapping("/entry")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequestDto requestDTO) throws Exception {
        Ticket response = ticketService.createTicket(requestDTO);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/exit/{ticketId}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable Long ticketId) throws ResourceNotFoundException {
        Ticket ticket = ticketService.closeTicket(ticketId);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/slots/reserve")
    public ResponseEntity<String> reserveSlot(@RequestParam Long slotId,
                                              @RequestParam String vehicleNumber) throws ResourceNotFoundException {
        ParkingSlot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new ResourceNotFoundException("Slot not found"));

        if (!slot.isAvailable()) {
            return ResponseEntity.badRequest().body("Slot is not available.");
        }

        slot.setReserved(true);
        slot.setReservedForVehicleNumber(vehicleNumber);

        slotRepository.save(slot);
        return ResponseEntity.ok("Slot reserved successfully for vehicle " + vehicleNumber);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketDto> getTicketDetails(@PathVariable Long id) throws ResourceNotFoundException {
        TicketDto dto = ticketService.getTicketDetails(id);
        return ResponseEntity.ok(dto);
    }

}
