package org.atyeti.student_attendance_Tracker.service;

import lombok.RequiredArgsConstructor;
import org.atyeti.student_attendance_Tracker.dao.LeaveRequestRepo;
import org.atyeti.student_attendance_Tracker.entity.LeaveRequest;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepository;
    public LeaveRequest submitLeaveRequest(Student student, String reason) {
        LeaveRequest leave = LeaveRequest.builder()
                .student(student)
                .reason(reason)
                .status("PENDING")
                .build();
        return leaveRequestRepository.save(leave);
    }


    public LeaveRequest updateLeaveStatus(Long leaveId, String status) {
        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus(status);
        return leaveRequestRepository.save(leave);
    }


    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }
}
