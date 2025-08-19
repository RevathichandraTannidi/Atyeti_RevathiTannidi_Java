package com.org.cabMate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Trip trip;
    @ManyToOne(optional = false)
    private Rider rider;
    @ManyToOne(optional = false)
    private Driver driver;


    private int rating;
    private String comment;
}
