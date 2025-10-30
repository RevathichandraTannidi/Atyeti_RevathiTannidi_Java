package org.atyeti.student_attendance_Tracker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.dao.LeaveRequestRepo;
import org.atyeti.student_attendance_Tracker.entity.LeaveRequest;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.enums.LeaveStatus;
import org.atyeti.student_attendance_Tracker.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepository;

    public LeaveRequest submitLeaveRequest(Student student, String reason) {
        log.info("Submitting leave for student={} reason={}", student.getEmail(), reason);
        LeaveRequest leave = LeaveRequest.builder()
                .student(student)
                .reason(reason).status(LeaveStatus.PENDING).build();
        LeaveRequest saved = leaveRequestRepository.save(leave);
        log.debug("Leave request saved id={}", saved.getId());
        return saved;
    }


    public LeaveRequest updateLeaveStatus(Long leaveId, LeaveStatus status) {
        log.info("Updating leave request id={} to status={}", leaveId, status);

        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> {
                    log.error("Leave request not found id={}", leaveId);
                    return new ResourceNotFoundException("Leave not found with id " + leaveId);
                });

        leave.setStatus(status);
        LeaveRequest updated = leaveRequestRepository.save(leave);
        log.debug("Leave request id={} updated to {}", leaveId, status);
        return updated;
    }


    public List<LeaveRequest> getAllLeaveRequests() {
        log.info("Fetching all leave requests");
        return leaveRequestRepository.findAll();
    }


    public List<LeaveRequest> getLeavesByStudent(Student student) {
        log.debug("Fetching leaves for student={}", student.getEmail());
        return leaveRequestRepository.findByStudent(student);
    }
}
