package org.atyeti.student_attendance_Tracker.dao;

import org.atyeti.student_attendance_Tracker.entity.LeaveRequest;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest,Long> {
    List<LeaveRequest> findByStudent(Student student);
}
