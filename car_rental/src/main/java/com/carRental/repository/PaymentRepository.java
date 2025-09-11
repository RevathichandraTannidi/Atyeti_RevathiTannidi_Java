package com.carRental.repository;


import com.carRental.entity.Payment;
import com.carRental.entity.enumss.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status);
    @Query("SELECT p FROM Payment p WHERE p.status = 'PENDING'")
    List<Payment> findPendingPayments();

    @Query("SELECT p FROM Payment p WHERE p.status = 'COMPLETED' AND p.amount >= :minAmount")
    List<Payment> findCompletedPaymentsAbove(double minAmount);
}
