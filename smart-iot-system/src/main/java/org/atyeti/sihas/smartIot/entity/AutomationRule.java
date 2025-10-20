package org.atyeti.sihas.smartIot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "automation_rules")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AutomationRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String conditionExpr;
    private String action;
    private boolean enabled;
    private String ownerUsername;
}
