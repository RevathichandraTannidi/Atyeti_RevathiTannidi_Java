package com.carRental.dtos;



import lombok.Data;
import java.time.LocalDate;

@Data
public class RentalHistoryDTO {
    private Long rentalId;
    private Long userId;
    private String username;
    private Long carId;
    private String carName;
    private String pickupBranch;
    private String dropoffBranch;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private double amount;
}




