package com.carRental.dtos;

import lombok.Data;

@Data
public class CarUsageDTO {
    private String carName;
    private long numberOfRentals;
}
