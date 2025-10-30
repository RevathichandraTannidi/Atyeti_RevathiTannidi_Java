package org.atyeti.student_attendance_Tracker.security;

import lombok.RequiredArgsConstructor;
import org.atyeti.student_attendance_Tracker.dao.StudentRepo;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles(student.getRole().name())
                .build();
    }
}
