package com.org.cabMate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vehicle;
    private double latitude;
    private double longitude;

    private boolean available = true;

    @OneToMany(mappedBy = "driver")
    private List<Trip> trips;

    private double avgRating = 0.0;
    private long ratingCount = 0;
    private long ratingSum = 0;

    public void addRating(int stars) {
        ratingSum += stars;
        ratingCount += 1;
        avgRating = (double) ratingSum / ratingCount;
    }

}
