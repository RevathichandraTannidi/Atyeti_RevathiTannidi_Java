package com.carRental.controller;

import com.carRental.dtos.RentalRequestDTO;
import com.carRental.dtos.RentalResponseDTO;
import com.carRental.entity.Rental;
import com.carRental.entity.enumss.RentalStatus;
import com.carRental.service.CarService;
import com.carRental.service.RentalService;
import com.carRental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    private final UserService userService;
    private final CarService carService;

    @PostMapping("/book")
    public RentalResponseDTO bookRental(@RequestBody RentalRequestDTO dto) {
        Rental rental = rentalService.bookRental(
                userService.getUserById(dto.getUserId()),
                carService.getCarById(dto.getCarId()),
                new com.carRental.entity.Branch() {{ setId(dto.getPickupBranchId()); }},
                new com.carRental.entity.Branch() {{ setId(dto.getDropoffBranchId()); }},
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getDiscountCode()
        );
        return toDTO(rental);
    }

    @PutMapping("/{id}/cancel")
    public RentalResponseDTO cancelRental(@PathVariable Long id) {
        return toDTO(rentalService.cancelRental(id));
    }

    @PutMapping("/{id}/complete")
    public RentalResponseDTO completeRental(@PathVariable Long id) {
        return toDTO(rentalService.completeRental(id));
    }

    @PutMapping("/{id}/status")
    public RentalResponseDTO updateRentalStatus(@PathVariable Long id,
                                                @RequestParam RentalStatus status) {
        return toDTO(rentalService.updateRentalStatus(id, status));
    }

    @GetMapping
    public List<RentalResponseDTO> getAllRentals() {
        return rentalService.getAllRentals()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/status/{status}")
    public List<RentalResponseDTO> getRentalsByStatus(@PathVariable RentalStatus status) {
        return rentalService.getRentalsByStatus(status)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/range")
    public List<RentalResponseDTO> getRentalsBetween(@RequestParam String start,
                                                     @RequestParam String end) {
        return rentalService.getRentalsBetween(
                        java.time.LocalDate.parse(start),
                        java.time.LocalDate.parse(end))
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private RentalResponseDTO toDTO(Rental rental) {
        RentalResponseDTO dto = new RentalResponseDTO();
        dto.setId(rental.getId());
        dto.setUserId(rental.getUser().getId());
        dto.setCarId(rental.getCar().getId());
        dto.setPickupBranchId(rental.getPickupBranch().getId());
        dto.setDropoffBranchId(rental.getDropoffBranch().getId());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        dto.setStatus(rental.getStatus());
        dto.setDiscountCode(rental.getDiscountCode());
        dto.setFinalAmount(String.valueOf(rental.getFinalAmount()));
        return dto;
    }
}
