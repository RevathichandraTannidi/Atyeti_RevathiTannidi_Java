package org.atyeti.sihas.smartIot.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_logs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DeviceLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private String payload;
    private LocalDateTime ts;
}

