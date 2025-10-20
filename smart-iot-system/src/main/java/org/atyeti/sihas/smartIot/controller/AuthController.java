package org.atyeti.sihas.smartIot.controller;


import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.dto.request.LoginRequest;
import org.atyeti.sihas.smartIot.dto.request.RegisterRequest;
import org.atyeti.sihas.smartIot.dto.response.JwtResponse;
import org.atyeti.sihas.smartIot.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }
}

