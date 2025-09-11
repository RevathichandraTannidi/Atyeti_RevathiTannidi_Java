package com.carRental.entity;

// entity/Invoice.java


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Invoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDateTime generatedAt;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}

