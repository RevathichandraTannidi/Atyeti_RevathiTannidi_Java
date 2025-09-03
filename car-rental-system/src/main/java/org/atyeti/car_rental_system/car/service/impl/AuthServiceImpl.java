package org.atyeti.car_rental_system.car.service.impl;



import lombok.RequiredArgsConstructor;
import org.atyeti.car_rental_system.car.dao.UserRepository;

import org.atyeti.car_rental_system.car.dtos.AuthDtos;
import org.atyeti.car_rental_system.car.entity.User;
import org.atyeti.car_rental_system.car.entity.enums.Role;
import org.atyeti.car_rental_system.car.security.jwt.JwtService;
import org.atyeti.car_rental_system.car.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

        @Override
        public AuthDtos.AuthResponse register(AuthDtos.RegisterRequest request) {
            User user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);

        String token = jwtService.generate(user.getEmail(), Map.of("role", user.getRole().name()));

        return new AuthDtos.AuthResponse(token, user.getEmail(), user.getRole().name());
    }



    @Override
    public AuthDtos.AuthResponse login(AuthDtos.LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generate(user.getEmail(), Map.of("role", user.getRole().name()));

        return new AuthDtos.AuthResponse(token, user.getEmail(), user.getRole().name());
    }


}
