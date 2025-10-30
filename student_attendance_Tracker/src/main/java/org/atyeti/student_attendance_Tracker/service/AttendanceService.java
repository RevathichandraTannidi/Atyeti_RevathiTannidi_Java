package org.atyeti.student_attendance_Tracker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.dao.AttendanceRepo;
import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.enums.AttendanceStatus;
import org.atyeti.student_attendance_Tracker.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepo attendanceRepository;

    public Attendance markAttendance(Student student, AttendanceStatus status) {
        log.info("Marking attendance for {} status={}", student.getEmail(), status);

        Attendance existing = attendanceRepository.findTodayAttendanceByStudent(student.getId());
        if (existing != null) {
            log.warn("Attendance already marked for {} today", student.getEmail());
            throw new ResourceNotFoundException("Attendance already marked for today");
        }

        Attendance attendance = Attendance.builder()
                .student(student)
                .status(status)
                .dateTime(LocalDateTime.now())
                .build();

        Attendance saved = attendanceRepository.save(attendance);
        log.debug("Attendance saved: id={} status={}", saved.getId(), saved.getStatus());
        return saved;
    }

    public List<Attendance> getTodayAttendance() {
        log.info("Fetching today's attendance list");
        return attendanceRepository.findTodayAttendance();
    }

    public long countByStatus(AttendanceStatus status) {
        return attendanceRepository.countByStatus(status);
    }

    public long countToday() {
        return attendanceRepository.countToday();
    }
}
