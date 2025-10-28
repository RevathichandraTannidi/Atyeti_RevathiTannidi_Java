package org.atyeti.student_attendance_Tracker.service;

import lombok.RequiredArgsConstructor;
import org.atyeti.student_attendance_Tracker.dao.AttendanceRepo;
import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepo attendanceRepository;
    public Attendance markAttendance(Student student, String status) {
        Attendance attendance = Attendance.builder()
                .student(student)
                .status(status)
                .dateTime(LocalDateTime.now())
                .build();

        return attendanceRepository.save(attendance);
    }
    public List<Attendance> getTodayAttendance() {
        return attendanceRepository.findTodayAttendance();
    }

    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public long countByStatus(String status) {
        return attendanceRepository.countByStatus(status);
    }
}
