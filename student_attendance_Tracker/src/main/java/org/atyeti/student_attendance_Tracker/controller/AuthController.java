package org.atyeti.student_attendance_Tracker.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.student_attendance_Tracker.entity.Student;
import org.atyeti.student_attendance_Tracker.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j

public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final StudentService studentService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        log.info("Register request for: {}", student.getEmail());
        return studentService.addStudent(student);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Student student = studentService.getStudentByEmail(loginRequest.getEmail());

            Map<String, Object> userData = new LinkedHashMap<>();
            userData.put("id", student.getId());
            userData.put("name", student.getName());
            userData.put("role", student.getRole().toString());

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("message", "Login successful");
            response.put("user", userData);

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        } catch (Exception e) {
            log.error("Login error", e);
            return ResponseEntity.status(500).body(Map.of("message", "Internal server error"));
        }
    }



    @GetMapping("/me")
    public Object currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getPrincipal() : "anonymous";
    }
}
