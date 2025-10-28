package org.atyeti.student_attendance_Tracker.dao;

import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance,Long> {
    @Query("SELECT a FROM Attendance a WHERE DATE(a.dateTime) = CURRENT_DATE")
    List<Attendance> findTodayAttendance();

    long countByStatus(String status);
}
