package com.carRental.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalRequestDTO {
    private Long userId;
    private Long carId;
    private Long pickupBranchId;
    private Long dropoffBranchId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String discountCode;


}
