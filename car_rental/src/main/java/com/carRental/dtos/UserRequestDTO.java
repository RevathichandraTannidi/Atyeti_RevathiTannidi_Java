package com.carRental.dtos;

import com.carRental.entity.enumss.Role;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
    private Role role;
}


