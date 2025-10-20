package org.atyeti.sihas.smartIot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.atyeti.sihas.smartIot.enums.RoleType;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
