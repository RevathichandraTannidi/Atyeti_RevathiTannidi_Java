package com.carRental.entity;

// entity/Notification.java


import com.carRental.entity.enumss.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private String message;

    @Column(name = "is_read")
    private boolean read;
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
