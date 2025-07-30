package com.parking.system.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int slotNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "slot_type", length = 20)
    private SlotType slotType;

    @Column(name = "is_available", nullable = false)

    private Boolean isAvailable;

    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved;

    private String reservedForVehicleNumber;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private ParkingFloor floor;
}
