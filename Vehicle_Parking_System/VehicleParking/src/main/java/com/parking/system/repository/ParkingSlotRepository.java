package com.parking.system.repository;

import com.parking.system.model.ParkingSlot;
import com.parking.system.model.SlotType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findFirstByAvailableTrueAndSlotType(SlotType slotType);
}