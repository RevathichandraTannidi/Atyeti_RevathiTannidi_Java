package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floorNumber;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<ParkingSlot> slots;
}

