package com.carRental.entity;
// entity/Branch.java


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Branch {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Car> cars;

    @OneToMany(mappedBy = "pickupBranch", cascade = CascadeType.ALL)
    private List<Rental> rentals;
}
