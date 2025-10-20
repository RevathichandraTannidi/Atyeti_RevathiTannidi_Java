package org.atyeti.sihas.smartIot.service;


import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.entity.Notification;
import org.atyeti.sihas.smartIot.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository repo;

    public Notification create(String username, String message) {
        Notification n = Notification.builder()
                .username(username)
                .message(message)
                .createdAt(LocalDateTime.now())
                .seen(false)
                .build();
        return repo.save(n);
    }

    public List<Notification> forUser(String username) {
        return repo.findByUsernameOrderByCreatedAtDesc(username);
    }
}
