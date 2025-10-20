package org.atyeti.sihas.smartIot.security;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.dto.request.LoginRequest;
import org.atyeti.sihas.smartIot.dto.request.RegisterRequest;
import org.atyeti.sihas.smartIot.dto.response.JwtResponse;
import org.atyeti.sihas.smartIot.entity.User;
import org.atyeti.sihas.smartIot.enums.RoleType;
import org.atyeti.sihas.smartIot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtProvider;

    public String register(RegisterRequest req) {
        if (userRepo.existsByUsername(req.getUsername())) throw new RuntimeException("User exists");
        User u = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(RoleType.valueOf(req.getRole() == null ? "USER" : req.getRole()))
                .build();
        userRepo.save(u);
        return "Registered";
    }

    public JwtResponse login(LoginRequest req) {
        User u = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(req.getPassword(), u.getPassword())) throw new RuntimeException("Invalid credentials");
        String token = jwtProvider.generateToken(u.getUsername(), u.getRole().name());
        return new JwtResponse(token, u.getUsername(), u.getRole().name());
    }
}

