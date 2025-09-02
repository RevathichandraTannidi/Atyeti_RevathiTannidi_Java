package org.atyeti.car_rental_system.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.atyeti.car_rental_system.car.entity.enums.Role;

import java.util.Set;

@Data
@Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    @Builder.Default
    private Integer loyaltyPoints = 0;


    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private Set<Rental> rentals;

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications;

}
