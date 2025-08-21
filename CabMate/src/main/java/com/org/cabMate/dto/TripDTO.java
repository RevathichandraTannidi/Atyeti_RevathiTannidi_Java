package com.org.cabMate.dto;


import com.org.cabMate.model.Trip;
import lombok.Data;
import java.time.Instant;

@Data
public class TripDTO {
    private Long id;
    private Long riderId;
    private Long driverId;
    private double distanceKm;
    private double fare;
    private double surgeMultiplier;
    private String status;
    private Instant requestedAt;
    private Instant startedAt;
    private Instant completedAt;

    public TripDTO(Trip trip) {
        this.id = trip.getId();
        this.riderId = trip.getRider().getId();
        this.driverId = trip.getDriver().getId();
        this.distanceKm = trip.getDistanceKm();
        this.fare = trip.getFare();
        this.surgeMultiplier = trip.getSurgeMultiplier();
        this.status = trip.getStatus() != null ? trip.getStatus().name() : null;
        this.requestedAt = trip.getRequestedAt();
        this.startedAt = trip.getStartedAt();
        this.completedAt = trip.getCompletedAt();
    }
}
