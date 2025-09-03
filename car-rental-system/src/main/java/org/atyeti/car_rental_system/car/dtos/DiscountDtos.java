package org.atyeti.car_rental_system.car.dtos;

import lombok.*;

public class DiscountDtos {



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DiscountRequest { // for creating a discount
        private String code;
        private double value; // discount value
        private int expiryDays; // optional, default to 30
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApplyDiscountRequest {
        private String code;
        private double price;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DiscountResponse {
        private String code;
        private double originalPrice;
        private double discountedPrice;
        private String message;
    }
}
