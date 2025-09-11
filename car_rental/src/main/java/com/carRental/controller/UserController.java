package com.carRental.controller;

import com.carRental.dtos.UserRequestDTO;
import com.carRental.dtos.UserResponseDTO;
import com.carRental.entity.User;
import com.carRental.entity.enumss.Role;
import com.carRental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        return toDTO(userService.registerUser(user));
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return toDTO(userService.getUserById(id));
    }
    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/role/{role}")
    public List<UserResponseDTO> getUsersByRole(@PathVariable Role role) {
        return userService.getUsersByRole(role)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<UserResponseDTO> searchUsersByName(@RequestParam String name) {
        return userService.searchUsersByName(name)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }


    @PutMapping("/{id}/loyalty")
    public UserResponseDTO updateLoyaltyPoints(@PathVariable Long id,
                                               @RequestParam int points) {
        return toDTO(userService.updateLoyaltyPoints(id, points));
    }

    private UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setLoyaltyPoints(user.getLoyaltyPoints());
        return dto;
    }
}
