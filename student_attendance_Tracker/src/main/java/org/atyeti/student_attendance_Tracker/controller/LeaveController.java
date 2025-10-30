package org.atyeti.student_attendance_Tracker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.entity.LeaveRequest;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.enums.LeaveStatus;
import org.atyeti.student_attendance_Tracker.service.LeaveRequestService;
import org.atyeti.student_attendance_Tracker.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveController {

    private final LeaveRequestService leaveService;
    private final StudentService studentService;


    @PostMapping("/student/{studentId}")
    public ResponseEntity<LeaveRequest> submitLeave(
            @PathVariable Long studentId,
            @RequestParam String reason
    ) {
        Student student = studentService.getStudentById(studentId);
        LeaveRequest leave = leaveService.submitLeaveRequest(student, reason);
        log.info("Leave submitted by student={} reason={}", student.getEmail(), reason);
        return ResponseEntity.ok(leave);
    }


    @GetMapping("/admin/all")
    public ResponseEntity<List<LeaveRequest>> getAllLeaves() {
        log.info("Fetching all leave requests");
        return ResponseEntity.ok(leaveService.getAllLeaveRequests());
    }


    @PutMapping("/admin/{leaveId}")
    public ResponseEntity<LeaveRequest> updateLeaveStatus(
            @PathVariable Long leaveId,
            @RequestParam LeaveStatus status
    ) {
        log.info("Updating leave id={} to status={}", leaveId, status);
        return ResponseEntity.ok(leaveService.updateLeaveStatus(leaveId, status));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<LeaveRequest>> getLeavesByStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        log.info("Fetching leave requests for student={}", student.getEmail());
        return ResponseEntity.ok(leaveService.getLeavesByStudent(student));
    }
}
