package org.atyeti.student_attendance_Tracker.dao;

import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Optional<Student> findByEmail(String email);
}
