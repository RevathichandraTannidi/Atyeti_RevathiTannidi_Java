package com.carRental.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceResponseDTO {
    private Long id;
    private Long rentalId;
    private Long carId;
    private double amount;
    private LocalDateTime generatedAt;
}
