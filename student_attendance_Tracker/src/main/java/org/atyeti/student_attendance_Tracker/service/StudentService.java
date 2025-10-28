package org.atyeti.student_attendance_Tracker.service;


import lombok.RequiredArgsConstructor;
import org.atyeti.student_attendance_Tracker.dao.StudentRepo;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Optional<Student> login(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent() && studentOpt.get().getPassword().equals(password)) {
            return studentOpt;
        }
        return Optional.empty();
    }
}

