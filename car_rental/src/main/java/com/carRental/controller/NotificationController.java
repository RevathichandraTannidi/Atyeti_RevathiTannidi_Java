package com.carRental.controller;

import com.carRental.dtos.NotificationRequestDTO;
import com.carRental.dtos.NotificationResponseDTO;
import com.carRental.entity.Notification;
import com.carRental.entity.User;
import com.carRental.service.NotificationService;
import com.carRental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final UserService userService;

    @PostMapping
    public NotificationResponseDTO sendNotification(@RequestBody NotificationRequestDTO dto) {
        Notification notification = new Notification();
        notification.setMessage(dto.getMessage());
        notification.setType(dto.getType());
        notification.setRead(dto.isRead());
        notification.setUser(userService.getUserById(dto.getUserId()));
        return toDTO(notificationService.sendNotification(notification));
    }

    @GetMapping("/user/{userId}")
    public List<NotificationResponseDTO> getUserNotifications(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return notificationService.getUserNotifications(user)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<NotificationResponseDTO> getAllNotificationsOrdered() {
        return notificationService.getAllNotificationsOrdered()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private NotificationResponseDTO toDTO(Notification n) {
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setId(n.getId());
        dto.setMessage(n.getMessage());
        dto.setType(n.getType());
        dto.setRead(n.isRead());
        dto.setCreatedAt(n.getCreatedAt());
        dto.setUserId(n.getUser() != null ? n.getUser().getId() : null);
        return dto;
    }
}

