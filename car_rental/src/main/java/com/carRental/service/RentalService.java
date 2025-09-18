package com.carRental.service;

import com.carRental.dtos.RevenueByCarDTO;
import com.carRental.dtos.RevenueByBranchDTO;
import com.carRental.entity.*;
import com.carRental.entity.enumss.RentalStatus;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final CarService carService;
    private final DiscountService discountService;


    public Rental bookRental(User user, Car car, Branch pickup, Branch dropoff,
                             LocalDate start, LocalDate end, String discountCode) {

        if (!car.isAvailable()) {
            throw new BadRequestException("Car with id " + car.getId() + " is not available");
        }
        if (start.isAfter(end)) {
            throw new BadRequestException("Start date cannot be after end date");
        }

        long days = end.toEpochDay() - start.toEpochDay() + 1;
        double totalAmount = car.getPricePerDay() * days;

        if (discountCode != null && !discountCode.isEmpty()) {
            totalAmount = discountService.applyDiscount(discountCode, totalAmount);
        }

        Rental rental = Rental.builder()
                .user(user)
                .car(car)
                .pickupBranch(pickup)
                .dropoffBranch(dropoff)
                .startDate(start)
                .endDate(end)
                .status(RentalStatus.BOOKED)
                .discountCode(discountCode)
                .finalAmount(totalAmount)
                .build();


        carService.updateAvailability(car.getId(), false, end.plusDays(1));

        return rentalRepository.save(rental);
    }

    public Rental cancelRental(Long rentalId) {
        Rental rental = getRentalById(rentalId);

        if (rental.getStatus() == RentalStatus.CANCELLED) {
            throw new BadRequestException("Rental is already cancelled");
        }

        rental.setStatus(RentalStatus.CANCELLED);


        carService.updateAvailability(rental.getCar().getId(), true, LocalDate.now());

        return rentalRepository.save(rental);
    }


    public Rental completeRental(Long rentalId) {
        Rental rental = getRentalById(rentalId);

        if (rental.getStatus() == RentalStatus.COMPLETED) {
            throw new BadRequestException("Rental is already completed");
        }
        if (rental.getStatus() == RentalStatus.CANCELLED) {
            throw new BadRequestException("Cannot complete a cancelled rental");
        }

        rental.setStatus(RentalStatus.COMPLETED);


        carService.updateAvailability(rental.getCar().getId(), true, rental.getEndDate().plusDays(1));

        return rentalRepository.save(rental);
    }

    public Rental updateRentalStatus(Long rentalId, RentalStatus status) {
        Rental rental = getRentalById(rentalId);
        rental.setStatus(status);
        return rentalRepository.save(rental);
    }


    public List<Rental> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        if (rentals.isEmpty()) {
            throw new ResourceNotFoundException("No rentals found");
        }
        return rentals;
    }


    public List<Rental> getRentalsByStatus(RentalStatus status) {
        List<Rental> rentals = rentalRepository.findByStatus(status);
        if (rentals.isEmpty()) {
            throw new ResourceNotFoundException("No rentals found with status: " + status);
        }
        return rentals;
    }


    public List<Rental> getRentalsBetween(LocalDate start, LocalDate end) {
        List<Rental> rentals = rentalRepository.findByStartDateBetween(start, end);
        if (rentals.isEmpty()) {
            throw new ResourceNotFoundException("No rentals found between " + start + " and " + end);
        }
        return rentals;
    }
    public List<RevenueByBranchDTO> getRevenueByBranch(LocalDate start, LocalDate end) {
        return rentalRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        r -> r.getPickupBranch().getName(),
                        Collectors.summingDouble(r -> r.getPayment() != null ? r.getPayment().getAmount() : 0)
                ))
                .entrySet().stream()
                .map(e -> {
                    RevenueByBranchDTO dto = new RevenueByBranchDTO();
                    dto.setBranchName(e.getKey());
                    dto.setTotalRevenue(e.getValue());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<RevenueByCarDTO> getRevenueByCar(LocalDate start, LocalDate end) {
        return rentalRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        r -> r.getCar().getBrand() + " " + r.getCar().getModel(),
                        Collectors.summingDouble(r -> r.getPayment() != null ? r.getPayment().getAmount() : 0)
                ))
                .entrySet().stream()
                .map(e -> {
                    RevenueByCarDTO dto = new RevenueByCarDTO();
                    dto.setCarName(e.getKey());
                    dto.setTotalRevenue(e.getValue());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    public Rental getRentalById(Long rentalId) {
        return rentalRepository.findById(rentalId)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found with id: " + rentalId));
    }
}
