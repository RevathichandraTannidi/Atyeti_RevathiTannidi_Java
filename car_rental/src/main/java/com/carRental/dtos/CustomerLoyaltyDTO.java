package com.carRental.dtos;

import lombok.Data;

@Data
public class CustomerLoyaltyDTO {
    private Long userId;
    private String username;
    private String email;
    private int loyaltyPoints;
    private long totalRentals;
    private double totalSpent;
}
