package com.carRental.repository;

import com.carRental.entity.enumss.RentalStatus;
import  org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import com.carRental.entity.*;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByStatus(RentalStatus status);
    List<Rental> findByStartDateBetween(LocalDate start, LocalDate end);
}
