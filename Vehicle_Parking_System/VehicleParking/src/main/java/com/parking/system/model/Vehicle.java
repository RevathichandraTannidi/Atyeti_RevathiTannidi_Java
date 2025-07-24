package com.parking.system.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    private String plateNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType type;
}
