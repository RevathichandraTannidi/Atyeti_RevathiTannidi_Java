package com.carRental.service;

import com.carRental.entity.Branch;
import com.carRental.entity.Car;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car addCar(Car car) {
        if (car == null) {
            throw new BadRequestException("Car cannot be null");
        }
        if (car.getPricePerDay() <= 0) {
            throw new BadRequestException("Car price per day must be greater than zero");
        }
        if (car.getMileage() < 0) {
            throw new BadRequestException("Car mileage cannot be negative");
        }
        return carRepository.save(car);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
    }

    public List<Car> getAvailableCars() {
        List<Car> cars = carRepository.findByAvailableTrue();
        if (cars.isEmpty()) {
            throw new ResourceNotFoundException("No available cars found");
        }
        return cars;
    }

    public List<Car> getCarsByBranch(Branch branch) {
        if (branch == null) {
            throw new BadRequestException("Branch cannot be null");
        }
        List<Car> cars = carRepository.findByBranch(branch);
        if (cars.isEmpty()) {
            throw new ResourceNotFoundException("No cars found for branch: " + branch.getName());
        }
        return cars;
    }

    public List<Car> getCarsAvailableBefore(LocalDate date) {
        if (date == null) {
            throw new BadRequestException("Date cannot be null");
        }
        List<Car> cars = carRepository.findByNextAvailableDateBefore(date);
        if (cars.isEmpty()) {
            throw new ResourceNotFoundException("No cars available before: " + date);
        }
        return cars;
    }

    public Car updateAvailability(Long carId, boolean available, LocalDate nextDate) {
        Car car = getCarById(carId);
        if (available && nextDate == null) {
            throw new BadRequestException("Next available date must be provided when marking car as available");
        }
        car.setAvailable(available);
        car.setNextAvailableDate(nextDate);
        return carRepository.save(car);
    }
}
