package org.atyeti.car_rental_system.car.dao;

import org.atyeti.car_rental_system.car.entity.Car;
import org.atyeti.car_rental_system.car.entity.Rental;
import org.atyeti.car_rental_system.car.entity.User;
import org.atyeti.car_rental_system.car.entity.enums.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Long> {
    List<Rental> findByUserId(User user);

    List<Rental> findByCar(Car car);

    List<Rental> findByStatus(RentalStatus status);


    @Query("SELECT r FROM Rental r WHERE r.car = :car AND r.status IN ('BOOKED','ONGOING') " +
           "AND (:startDate <= r.endDate AND :endDate >= r.startDate)")
    List<Rental> findConflictingRentals(Car car, LocalDate startDate, LocalDate endDate);

    @Query("SELECT r FROM Rental r WHERE r.startDate BETWEEN :from AND :to OR r.endDate BETWEEN :from AND :to")
    List<Rental> findRentalsBetweenDates(LocalDate from, LocalDate to);
}

