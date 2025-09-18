package com.carRental.service;

import com.carRental.entity.User;
import com.carRental.entity.enumss.Role;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already in use: " + user.getEmail());
        }

        //  want to allow duplicate usernames, remove the following check
        /*
        List<User> existingUsers = userRepository.findByUsername(user.getUsername());
        if (!existingUsers.isEmpty()) {
            throw new BadRequestException("Username already taken: " + user.getUsername());
        }
        */

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email " + email));
    }


    public List<User> getUsersByRole(Role role) {
        List<User> users = userRepository.findByRole(role);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found with role " + role);
        }
        return users;
    }


    public List<User> searchUsersByName(String name) {
        List<User> users = userRepository.searchByUsername(name);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found matching name: " + name);
        }
        return users;
    }


    public User updateLoyaltyPoints(Long userId, int points) {
        if (points <= 0) {
            throw new BadRequestException("Loyalty points must be positive");
        }
        User user = getUserById(userId);
        user.setLoyaltyPoints(user.getLoyaltyPoints() + points);
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
