package org.atyeti.student_attendance_Tracker.entity;
import jakarta.persistence.*;
import lombok.*;
import org.atyeti.student_attendance_Tracker.enums.UserRole;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rollNumber;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.STUDENT;
}