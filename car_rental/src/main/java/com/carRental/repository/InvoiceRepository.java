package com.carRental.repository;

import com.carRental.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByGeneratedAtBetween(LocalDateTime start, LocalDateTime end);
}
