package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private double fee;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private ParkingSlot slot;


    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
