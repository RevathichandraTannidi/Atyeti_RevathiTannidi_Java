package com.parking.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    private String id;

    @ManyToOne
    private ParkingSlot slot;

    @OneToOne
    private Vehicle vehicle;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
