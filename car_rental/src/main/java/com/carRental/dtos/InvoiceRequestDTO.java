package com.carRental.dtos;

import lombok.Data;

@Data
public class InvoiceRequestDTO {
    private Long rentalId;
    private double amount;
}

