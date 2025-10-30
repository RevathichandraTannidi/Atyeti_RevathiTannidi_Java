package org.atyeti.student_attendance_Tracker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.enums.AttendanceStatus;
import org.atyeti.student_attendance_Tracker.service.AttendanceService;
import org.atyeti.student_attendance_Tracker.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentService studentService;

    @PostMapping("/mark/{studentId}")
    public ResponseEntity<Attendance> markAttendance(
            @PathVariable Long studentId,
            @RequestParam AttendanceStatus status
    ) {
        Student student = studentService.getStudentById(studentId);
        Attendance attendance = attendanceService.markAttendance(student, status);
        log.info("Attendance marked for studentId={} status={}", studentId, status);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping("/summary/today")
    public ResponseEntity<Map<String, Long>> todaySummary() {
        long present = attendanceService.countByStatus(AttendanceStatus.PRESENT);
        long absent = attendanceService.countByStatus(AttendanceStatus.ABSENT);
        long leave = attendanceService.countByStatus(AttendanceStatus.LEAVE);
        long total = studentService.getAllStudents().size();
        long marked = attendanceService.countToday();

        Map<String, Long> summary = new LinkedHashMap<>();
        summary.put("totalStudents", total);
        summary.put("markedToday", marked);
        summary.put("present", present);
        summary.put("absent", absent);
        summary.put("leave", leave);

        log.info("Today's summary: {}", summary);
        return ResponseEntity.ok(summary);
    }


    @GetMapping("/today")
    public ResponseEntity<List<Attendance>> getTodayAttendance() {
        List<Attendance> attendanceList = attendanceService.getTodayAttendance();
        log.info("Fetched {} attendance records for today", attendanceList.size());
        return ResponseEntity.ok(attendanceList);
    }
}
