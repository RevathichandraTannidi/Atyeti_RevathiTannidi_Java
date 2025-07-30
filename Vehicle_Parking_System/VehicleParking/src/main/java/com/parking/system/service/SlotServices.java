package com.parking.system.service;

import com.parking.system.dto.TicketDto;
import com.parking.system.model.ParkingSlot;
import com.parking.system.model.SlotType;
import com.parking.system.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SlotServices {

    @Autowired
    private ParkingSlotRepository slotRepository;

    public ParkingSlot assignAvailableSlot(TicketDto ticketDto) {

        String vehicleTypeStr = ticketDto.getVehicleType();

        SlotType slotType;
        try {
            slotType = SlotType.valueOf(vehicleTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleTypeStr);
        }

        Optional<ParkingSlot> optionalSlot = slotRepository.findFirstByAvailableTrueAndSlotType(slotType);
        if (optionalSlot.isEmpty()) {
            throw new RuntimeException("No available slots for type: " + slotType);
        }

        ParkingSlot slot = optionalSlot.get();
        slot.setIsAvailable(false);
        return slotRepository.save(slot);
    }

    public void freeSlot(Long slotId) {
        Optional<ParkingSlot> optionalSlot = slotRepository.findById(slotId);
        if (optionalSlot.isPresent()) {
            ParkingSlot slot = optionalSlot.get();
            slot.setIsAvailable(true); // mark as free
            slotRepository.save(slot);
        } else {
            throw new RuntimeException("Slot not found with id: " + slotId);
        }
    }
}