package org.atyeti.car_rental_system.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atyeti.car_rental_system.car.entity.enums.PaymentStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Rental rental;

    private double amount;
    private String method;


    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}
