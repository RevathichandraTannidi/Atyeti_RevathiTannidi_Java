package com.parking.system.service;

import com.parking.system.dto.TicketDto;
import com.parking.system.dto.TicketRequestDto;
import com.parking.system.exception.ResourceNotFoundException;
import com.parking.system.model.ParkingSlot;
import com.parking.system.model.Ticket;
import com.parking.system.model.Vehicle;
import com.parking.system.model.VehicleType;
import com.parking.system.repository.ParkingSlotRepository;
import com.parking.system.repository.TicketRepository;
import com.parking.system.repository.VehicleRepository;
import com.parking.system.service.TicketSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
@Service
public class TicketService implements TicketSer {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Override
    public Ticket createTicket(TicketRequestDto requestDTO) throws ResourceNotFoundException {

        ParkingSlot slot = parkingSlotRepository.findById(requestDTO.getSlotId())
                .orElseThrow(() -> new ResourceNotFoundException("Slot not found with id: " + requestDTO.getSlotId()));


        if (!slot.getIsAvailable()) {
            throw new IllegalStateException("Parking slot is already occupied.");
        }

        if (requestDTO.getVehiclePlateNumber() == null || requestDTO.getVehiclePlateNumber().isBlank()) {
            throw new IllegalArgumentException("Vehicle plate number must not be empty.");
        }


        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(requestDTO.getVehicleType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid slot type: " + requestDTO.getVehicleType());
        }

        Vehicle vehicle = vehicleRepository.findByPlateNumber(requestDTO.getVehiclePlateNumber())
                .orElseGet(() -> {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setPlateNumber(requestDTO.getVehiclePlateNumber());
                    newVehicle.setType(vehicleType);
                    return vehicleRepository.save(newVehicle);
                });

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setSlot(slot);
        ticket.setEntryTime(LocalDateTime.now());

        slot.setIsAvailable(false);
        parkingSlotRepository.save(slot);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket closeTicket(Long ticketId) throws ResourceNotFoundException {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));

        if (ticket.getExitTime() != null) {
            throw new IllegalStateException("Ticket already closed.");
        }

        ticket.setExitTime(LocalDateTime.now());

        long hours = Math.max(1, Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours());
        double fee = hours * 20;
        ticket.setFee(fee);

        ParkingSlot slot = ticket.getSlot();
        slot.setIsAvailable(true);
        parkingSlotRepository.save(slot);

        return ticketRepository.save(ticket);
    }

    @Override
    public TicketDto getTicketDetails(Long id) throws ResourceNotFoundException {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));

        TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setVehicleNumber(ticket.getVehicle().getPlateNumber());
        dto.setVehicleType(ticket.getVehicle().getType().name());
        dto.setSlotId(ticket.getSlot().getId());
        dto.setEntryTime(ticket.getEntryTime());
        dto.setExitTime(ticket.getExitTime());
        dto.setTotalAmount(ticket.getFee());

        return dto;
    }
}