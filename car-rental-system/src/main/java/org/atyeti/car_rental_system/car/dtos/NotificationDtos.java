package org.atyeti.car_rental_system.car.dtos;


import lombok.*;
import java.time.LocalDateTime;

public class NotificationDtos {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NotificationRequest {
        private Long userId;
        private String type;
        private String message;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class NotificationResponse {
        private Long notificationId;
        private String message;
        private String type;
        private String status;
        private LocalDateTime createdAt;
    }
}
