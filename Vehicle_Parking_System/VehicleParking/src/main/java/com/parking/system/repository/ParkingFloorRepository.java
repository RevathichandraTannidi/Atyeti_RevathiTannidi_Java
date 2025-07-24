package com.parking.system.repository;

import com.parking.system.model.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {
}
