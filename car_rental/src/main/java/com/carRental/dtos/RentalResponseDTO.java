package com.carRental.dtos;

import com.carRental.entity.enumss.RentalStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalResponseDTO {
    private Long id;
    private Long userId;
    private Long carId;
    private Long pickupBranchId;
    private Long dropoffBranchId;
    private LocalDate startDate;
    private LocalDate endDate;
    private RentalStatus status;
    private String discountCode;
    private String finalAmount;
}
