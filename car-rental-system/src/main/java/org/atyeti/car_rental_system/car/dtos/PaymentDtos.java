package org.atyeti.car_rental_system.car.dtos;

import lombok.*;

public class PaymentDtos {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentRequest {
        private Long rentalId;
        private double amount;
        private String method;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaymentResponse {
        private Long paymentId;
        private double amount;
        private String method;
        private String status;
        private String timestamp;
    }
}
