package com.carRental.controller;

import com.carRental.dtos.CarRequestDTO;
import com.carRental.dtos.CarResponseDTO;
import com.carRental.entity.Car;
import com.carRental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public CarResponseDTO addCar(@RequestBody CarRequestDTO dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setBrand(dto.getBrand());
        car.setYear(dto.getYear());
        car.setPricePerDay(dto.getPricePerDay());
        car.setMileage(dto.getMileage());
        car.setAvailable(dto.isAvailable());
        car.setNextAvailableDate(dto.getNextAvailableDate());

        if (dto.getBranchId() != null) {
            car.setBranch(new com.carRental.entity.Branch() {{ setId(dto.getBranchId()); }});
        }

        return toDTO(carService.addCar(car));
    }


    @GetMapping("/{id}")
    public CarResponseDTO getCarById(@PathVariable Long id) {
        return toDTO(carService.getCarById(id));
    }

    @GetMapping("/available")
    public List<CarResponseDTO> getAvailableCars() {
        return carService.getAvailableCars()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/branch/{branchId}")
    public List<CarResponseDTO> getCarsByBranch(@PathVariable Long branchId) {

        return carService.getCarsByBranch(new com.carRental.entity.Branch() {{ setId(branchId); }})
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/available-before")
    public List<CarResponseDTO> getCarsAvailableBefore(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return carService.getCarsAvailableBefore(localDate)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }
    @PutMapping("/{id}/availability")
    public CarResponseDTO updateCarAvailability(@PathVariable Long id,
                                                @RequestParam boolean available,
                                                @RequestParam(required = false) String nextDate) {
        LocalDate date = null;
        if (available) {
            // If available, either take provided date or use today
            date = nextDate != null ? LocalDate.parse(nextDate) : LocalDate.now();
        }

        Car updatedCar = carService.updateAvailability(id, available, date);
        return toDTO(updatedCar);
    }


    private CarResponseDTO toDTO(Car car) {
        CarResponseDTO dto = new CarResponseDTO();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setBrand(car.getBrand());
        dto.setYear(car.getYear());
        dto.setPricePerDay(car.getPricePerDay());
        dto.setMileage(car.getMileage());
        dto.setAvailable(car.isAvailable());
        dto.setNextAvailableDate(car.getNextAvailableDate());
        dto.setBranchId(car.getBranch() != null ? car.getBranch().getId() : null);
        return dto;
    }
}

