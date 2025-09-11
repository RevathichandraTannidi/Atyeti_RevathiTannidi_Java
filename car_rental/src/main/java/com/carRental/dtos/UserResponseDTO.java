package com.carRental.dtos;

import com.carRental.entity.enumss.Role;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private Role role;
    private int loyaltyPoints;
}
