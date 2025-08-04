package com.example.inventory.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReportJobStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobType;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private String reportPath;
}
