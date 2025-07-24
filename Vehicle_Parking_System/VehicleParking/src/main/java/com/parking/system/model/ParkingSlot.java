package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotNumber;
    private boolean occupied;

    @Enumerated(EnumType.STRING)
    private VehicleType supportedType;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private ParkingFloor floor;
}
