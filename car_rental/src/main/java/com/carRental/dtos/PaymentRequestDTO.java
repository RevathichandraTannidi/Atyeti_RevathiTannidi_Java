package com.carRental.dtos;

import com.carRental.entity.enumss.PaymentStatus;
import lombok.Data;


@Data
public class PaymentRequestDTO {
    private Long rentalId;
    private double amount;
    private String method;
    private String discountCode;
private PaymentStatus    status;
}

