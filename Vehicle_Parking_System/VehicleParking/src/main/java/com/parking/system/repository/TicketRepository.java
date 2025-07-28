package com.parking.system.repository;

import com.parking.system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByVehiclePlateNumberAndExitTimeIsNull(String plateNumber);
}
