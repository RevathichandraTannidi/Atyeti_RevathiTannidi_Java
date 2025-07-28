package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotNumber;
    private boolean isAvailable=true;
    private boolean isReserved=false;

    private String slotType;
    // compact ,large ,handicapped
    private String reservedForVehicleNumber;
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private ParkingFloor floor;
}
