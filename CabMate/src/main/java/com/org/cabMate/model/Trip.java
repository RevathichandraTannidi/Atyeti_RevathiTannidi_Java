package com.org.cabMate.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Rider rider;

    @ManyToOne(optional = false)
    private Driver driver;

    private double distanceKm;
    private double fare;
    private double surgeMultiplier;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    private Instant requestedAt;
    private Instant startedAt;
    private Instant completedAt;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Feedback feedback;


    public Trip(Object o, Rider rider, Driver driver, double distanceKm, double fare, double surgeMultiplier, RideStatus rideStatus, Instant now, Object o1, Object o2) {
    }
}
