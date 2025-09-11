package com.carRental.dtos;

import com.carRental.entity.enumss.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Long rentalId;
    private double amount;
    private String method;
    private PaymentStatus status;
    private LocalDateTime timestamp;
    private String discountCode;

}
