package org.atyeti.car_rental_system.car.dao;

import org.atyeti.car_rental_system.car.entity.Branch;
import org.atyeti.car_rental_system.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByBranchAndAvailableTrue(Branch branch);

    @Query("SELECT c FROM Car c WHERE c.available = true AND c.branch = :branch " +
            "AND c.nextAvailableDate <= :date")
    List<Car> findAvailableCarsByBranchAndDate(Branch branch, LocalDate date);

    @Query("SELECT c FROM Car c WHERE lower(c.model) LIKE lower(concat('%', :keyword, '%')) " +
            "OR lower(c.brand) LIKE lower(concat('%', :keyword, '%'))")
    List<Car> searchByModelOrBrand(String keyword);
}
