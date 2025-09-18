package com.carRental.entity;

// entity/Payment.java

import com.carRental.entity.enumss.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    @JsonCreator
    public Payment(@JsonProperty("status") PaymentStatus status) {
        this.status = status;
    }


    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    @Column(nullable = true)
    private String discountCode;

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();
    }
}
