package org.atyeti.student_attendance_Tracker.dao;

import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.atyeti.student_attendance_Tracker.enums.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    @Query("SELECT a FROM Attendance a WHERE DATE(a.dateTime) = CURRENT_DATE")
    List<Attendance> findTodayAttendance();

    long countByStatus(AttendanceStatus status);

    @Query("SELECT COUNT(a) FROM Attendance a WHERE DATE(a.dateTime) = CURRENT_DATE")
    long countToday();

    @Query("SELECT a FROM Attendance a WHERE a.student.id = :studentId AND DATE(a.dateTime) = CURRENT_DATE")
    Attendance findTodayAttendanceByStudent(Long studentId);
}

