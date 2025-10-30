package org.atyeti.student_attendance_Tracker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.dao.StudentRepo;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepository;
    private final PasswordEncoder passwordEncoder;

    public Student addStudent(Student student) {
        log.info("Adding student: {}", student.getEmail());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Student saved = studentRepository.save(student);
        log.debug("Student saved id={}", saved.getId());
        return saved;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }


    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with email " + email));
    }


    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            log.warn("Attempt to delete non-existing student id={}", id);
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
        log.info("Deleted student id={}", id);
    }


    public Optional<Student> login(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent() && passwordEncoder.matches(password, studentOpt.get().getPassword())) {
            log.info("Student logged in successfully: {}", email);
            return studentOpt;
        }
        log.warn("Invalid login attempt for: {}", email);
        return Optional.empty();
    }
}
