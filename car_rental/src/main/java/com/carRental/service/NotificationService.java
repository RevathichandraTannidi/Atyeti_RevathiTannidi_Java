package com.carRental.service;

import com.carRental.entity.Notification;
import com.carRental.entity.User;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Notification sendNotification(Notification notification) {
        if (notification.getUser() == null) {
            throw new BadRequestException("Notification must be associated with a user");
        }
        if (notification.getMessage() == null || notification.getMessage().isEmpty()) {
            throw new BadRequestException("Notification message cannot be empty");
        }
        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(User user) {
        if (user == null) {
            throw new BadRequestException("User cannot be null");
        }
        List<Notification> notifications = notificationRepository.findByUser(user);
        if (notifications.isEmpty()) {
            throw new ResourceNotFoundException("No notifications found for user: " + user.getUsername());
        }
        return notifications;
    }

    public List<Notification> getAllNotificationsOrdered() {
        List<Notification> notifications = notificationRepository.findAllOrderedByDate();
        if (notifications.isEmpty()) {
            throw new ResourceNotFoundException("No notifications found in the system");
        }
        return notifications;
    }
}
