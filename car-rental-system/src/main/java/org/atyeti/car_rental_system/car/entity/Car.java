package org.atyeti.car_rental_system.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String brand;
    private int year;
    private double pricePerDay;
    private double mileage;
    @Builder.Default
    private boolean available = true;
    private LocalDate nextAvailableDate;


    @ManyToOne
    private Branch branch;
}
