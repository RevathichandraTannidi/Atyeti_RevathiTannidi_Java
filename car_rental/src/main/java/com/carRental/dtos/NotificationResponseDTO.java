package com.carRental.dtos;

import com.carRental.entity.enumss.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private Long id;
    private Long userId;
    private NotificationType type;
    private String message;
    private boolean read;
    private LocalDateTime createdAt;
}
