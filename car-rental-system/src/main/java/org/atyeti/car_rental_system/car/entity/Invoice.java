package org.atyeti.car_rental_system.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    private Rental rental;

    private Double amount;
@Builder.Default
    private LocalDateTime generatedAt = LocalDateTime.now();
}
