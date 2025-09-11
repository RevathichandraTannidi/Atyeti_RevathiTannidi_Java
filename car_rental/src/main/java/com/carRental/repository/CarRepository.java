package com.carRental.repository;



import com.carRental.entity.Branch;
import com.carRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailableTrue();
    List<Car> findByBranch(Branch branch);
    List<Car> findByNextAvailableDateBefore(LocalDate date);
}

