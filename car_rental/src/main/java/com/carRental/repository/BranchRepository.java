package com.carRental.repository;
import com.carRental.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByName(String name);

    @Query("SELECT b FROM Branch b WHERE lower(b.name) LIKE lower(concat('%', :name, '%'))")
    List<Branch> searchByName(String name);

    List<Branch> findByAddressContainingIgnoreCase(String address);
}
