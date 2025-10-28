package org.atyeti.student_attendance_Tracker.dao;

import org.atyeti.student_attendance_Tracker.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest,Long> {
}
