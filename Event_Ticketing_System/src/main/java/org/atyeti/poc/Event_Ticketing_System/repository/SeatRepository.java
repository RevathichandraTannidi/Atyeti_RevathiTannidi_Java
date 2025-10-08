package org.atyeti.poc.Event_Ticketing_System.repository;


import org.atyeti.poc.Event_Ticketing_System.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    Optional<Seat> findBySeatIdAndStatus(String seatId, String status);
}
