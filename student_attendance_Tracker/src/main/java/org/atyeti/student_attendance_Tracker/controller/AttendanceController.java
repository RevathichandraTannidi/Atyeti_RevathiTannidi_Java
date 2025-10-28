package org.atyeti.student_attendance_Tracker.controller;

import lombok.RequiredArgsConstructor;
import org.atyeti.student_attendance_Tracker.entity.Attendance;
import org.atyeti.student_attendance_Tracker.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/summary/today")
    public Map<String, Long> getTodaySummary() {
        Map<String, Long> desc = new HashMap<>();
        desc.put("present", attendanceService.countByStatus("PRESENT"));
        desc.put("absent", attendanceService.countByStatus("ABSENT"));
        desc.put("leave", attendanceService.countByStatus("LEAVE"));
        desc.put("total", desc.values().stream().reduce(0L, Long::sum));
        return desc;
    }

    @GetMapping("/today")
    public List<Attendance> getTodayAttendance() {
        return attendanceService.getTodayAttendance();
    }

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.markAttendance(attendance);
    }
}

