package org.atyeti.sihas.smartIot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.atyeti.sihas.smartIot.enums.DeviceStatus;
import org.atyeti.sihas.smartIot.enums.DeviceType;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String deviceId;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    private String location;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;
}
