package com.carRental.controller;



import com.carRental.dtos.PaymentRequestDTO;
import com.carRental.dtos.PaymentResponseDTO;
import com.carRental.entity.Payment;
import com.carRental.entity.enumss.PaymentStatus;
import com.carRental.service.DiscountService;
import com.carRental.service.PaymentService;
import com.carRental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final DiscountService discountService;
    private final RentalService rentalService;

    @PostMapping("/process")
    public PaymentResponseDTO processPayment(@RequestBody PaymentRequestDTO dto) {
        double finalAmount = dto.getDiscountCode() != null
                ? discountService.applyDiscount(dto.getDiscountCode(), dto.getAmount())
                : dto.getAmount();

        Payment payment = new Payment();
        payment.setRental(dto.getRentalId() != null ? rentalService.getRentalById(dto.getRentalId()) : null);
        payment.setAmount(finalAmount);
        payment.setMethod(dto.getMethod());
        payment.setDiscountCode(dto.getDiscountCode());


        payment.setStatus(dto.getStatus() != null ? dto.getStatus() : PaymentStatus.PENDING);

        Payment saved = paymentService.processPayment(payment);
        return toDTO(saved);
    }

    @GetMapping("/status/{status}")
    public List<PaymentResponseDTO> getPaymentsByStatus(@PathVariable PaymentStatus status) {
        return paymentService.getPaymentsByStatus(status)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/pending")
    public List<PaymentResponseDTO> getPendingPayments() {
        return paymentService.getPendingPayments()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}/status")
    public PaymentResponseDTO updatePaymentStatus(@PathVariable Long id,
                                                  @RequestParam PaymentStatus status) {
        Payment updated = paymentService.updatePaymentStatus(id, status);
        return toDTO(updated);
    }


    @GetMapping("/completed/highvalue")
    public List<PaymentResponseDTO> getHighValueCompletedPayments(@RequestParam double minAmount) {
        return paymentService.getHighValueCompletedPayments(minAmount)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private PaymentResponseDTO toDTO(Payment p) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(p.getId());
        dto.setRentalId(p.getRental() != null ? p.getRental().getId() : null);
        dto.setAmount(p.getAmount());
        dto.setMethod(p.getMethod());
        dto.setStatus(p.getStatus());
        dto.setTimestamp(p.getTimestamp());
        dto.setDiscountCode(p.getDiscountCode());
        return dto;
    }
}

