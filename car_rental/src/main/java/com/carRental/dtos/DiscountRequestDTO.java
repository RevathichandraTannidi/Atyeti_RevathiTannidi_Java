package com.carRental.dtos;

import com.carRental.entity.enumss.DiscountType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountRequestDTO {
    private String code;
    private DiscountType type;
    private double value;
    private LocalDate expiryDate;
}

