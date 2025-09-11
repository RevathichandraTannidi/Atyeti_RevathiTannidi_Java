package com.carRental.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarResponseDTO {
    private Long id;
    private String model;
    private String brand;
    private int year;
    private double pricePerDay;
    private double mileage;
    private boolean available;
    private LocalDate nextAvailableDate;
    private long branchId;
}
