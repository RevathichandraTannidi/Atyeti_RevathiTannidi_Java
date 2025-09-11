package com.carRental.service;

import com.carRental.entity.Payment;
import com.carRental.entity.enumss.PaymentStatus;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.PaymentFailedException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        if (payment.getAmount() <= 0) {
            throw new BadRequestException("Payment amount must be greater than 0");
        }
        try {

            return paymentRepository.save(payment);
        } catch (Exception e) {
            throw new PaymentFailedException("Failed to process payment for amount: " + payment.getAmount());
        }
    }

    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        List<Payment> payments = paymentRepository.findByStatus(status);
        if (payments.isEmpty()) {
            throw new ResourceNotFoundException("No payments found with status: " + status);
        }
        return payments;
    }

    public List<Payment> getPendingPayments() {
        List<Payment> payments = paymentRepository.findPendingPayments();
        if (payments.isEmpty()) {
            throw new ResourceNotFoundException("No pending payments found");
        }
        return payments;
    }
    public Payment updatePaymentStatus(Long paymentId, PaymentStatus status) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        if (payments.isEmpty()) {
            throw new ResourceNotFoundException("No payments found");
        }
        return payments;
    }


    public List<Payment> getHighValueCompletedPayments(double minAmount) {
        if (minAmount <= 0) {
            throw new BadRequestException("Minimum amount must be greater than 0");
        }
        List<Payment> payments = paymentRepository.findCompletedPaymentsAbove(minAmount);
        if (payments.isEmpty()) {
            throw new ResourceNotFoundException("No completed payments found above amount: " + minAmount);
        }
        return payments;
    }
}
