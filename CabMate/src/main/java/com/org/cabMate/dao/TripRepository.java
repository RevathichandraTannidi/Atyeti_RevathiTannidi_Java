package com.org.cabMate.dao;

import com.org.cabMate.model.Trip;
import com.org.cabMate.model.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByStatus(RideStatus status);
    List<Trip> findByRiderId(Long riderId);
    List<Trip> findByDriverId(Long driverId);
}
