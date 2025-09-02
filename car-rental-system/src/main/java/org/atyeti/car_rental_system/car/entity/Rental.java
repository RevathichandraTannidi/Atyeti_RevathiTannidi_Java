package org.atyeti.car_rental_system.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atyeti.car_rental_system.car.entity.enums.RentalStatus;

import java.time.LocalDate;

@Entity
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus status = RentalStatus.BOOKED;

    @ManyToOne
    private Branch pickupBranch;

    @ManyToOne
    private Branch dropoffBranch;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
