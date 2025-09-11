package com.carRental.entity;

import com.carRental.entity.enumss.RentalStatus;
// entity/Rental.java

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Rental {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Branch pickupBranch;

    @ManyToOne
    private Branch dropoffBranch;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Invoice invoice;


    private String discountCode;

    private double finalAmount;

}
