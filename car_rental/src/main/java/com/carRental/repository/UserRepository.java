package com.carRental.repository;
import com.carRental.entity.*;
import com.carRental.entity.enumss.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

        List<User> findByUsername(String username);

    List<User> findByRole(Role role);

    @Query("SELECT u FROM User u WHERE lower(u.username) LIKE lower(concat('%', :name, '%'))")
    List<User> searchByUsername(String name);
}

