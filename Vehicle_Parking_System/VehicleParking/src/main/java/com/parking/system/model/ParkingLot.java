package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
private String Location;
    @OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
    private List<ParkingFloor> floors;
}
