package org.atyeti.car_rental_system.car.dtos;



import lombok.*;
import java.time.LocalDate;

public class RentalDtos {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RentalRequest {
        private Long userId;
        private Long carId;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long pickupBranchId;
        private Long dropoffBranchId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RentalResponse {
        private Long rentalId;
        private String carModel;
        private String userEmail;
        private LocalDate startDate;
        private LocalDate endDate;
        private String status;
        private String pickupBranch;
        private String dropoffBranch;
    }

}
