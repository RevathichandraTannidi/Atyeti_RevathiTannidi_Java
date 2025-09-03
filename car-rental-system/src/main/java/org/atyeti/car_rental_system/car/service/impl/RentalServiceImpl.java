package org.atyeti.car_rental_system.car.service.impl;

import lombok.RequiredArgsConstructor;
import org.atyeti.car_rental_system.car.dao.BranchRepository;
import org.atyeti.car_rental_system.car.dao.CarRepository;
import org.atyeti.car_rental_system.car.dao.RentalRepository;
import org.atyeti.car_rental_system.car.dao.UserRepository;
import org.atyeti.car_rental_system.car.dtos.RentalDtos;
import org.atyeti.car_rental_system.car.entity.Branch;
import org.atyeti.car_rental_system.car.entity.Car;
import org.atyeti.car_rental_system.car.entity.Rental;
import org.atyeti.car_rental_system.car.entity.User;
import org.atyeti.car_rental_system.car.entity.enums.RentalStatus;
import org.atyeti.car_rental_system.car.service.RentalService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final BranchRepository branchRepository;

    @Override
    public RentalDtos.RentalResponse bookRental(RentalDtos.RentalRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (!isCarAvailable(car.getId(), request.getStartDate(), request.getEndDate())) {
            throw new RuntimeException("Car is not available for the selected dates");
        }

        Branch pickupBranch = request.getPickupBranchId() != null ?
                branchRepository.findById(request.getPickupBranchId())
                        .orElseThrow(() -> new RuntimeException("Pickup branch not found"))
                : car.getBranch();

        Branch dropoffBranch = request.getDropoffBranchId() != null ?
                branchRepository.findById(request.getDropoffBranchId())
                        .orElseThrow(() -> new RuntimeException("Dropoff branch not found"))
                : car.getBranch();

        Rental rental = Rental.builder()
                .user(user)
                .car(car)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .pickupBranch(pickupBranch)
                .dropoffBranch(dropoffBranch)
                .status(RentalStatus.BOOKED)
                .build();

        rentalRepository.save(rental);

        return mapToResponse(rental);
    }

    @Override
    public RentalDtos.RentalResponse cancelRental(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        rental.setStatus(RentalStatus.CANCELLED);
        rentalRepository.save(rental);

        return mapToResponse(rental);
    }

    @Override
    public RentalDtos.RentalResponse extendRental(Long rentalId, LocalDate newEndDate) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        if (!isCarAvailable(rental.getCar().getId(), rental.getEndDate().plusDays(1), newEndDate)) {
            throw new RuntimeException("Car is not available for the extended period");
        }

        rental.setEndDate(newEndDate);
        rentalRepository.save(rental);

        return mapToResponse(rental);
    }

    @Override
    public List<RentalDtos.RentalResponse> getUserRentals(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Rental> rentals = rentalRepository.findByUserId(user);
        return rentals.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isCarAvailable(Long carId, LocalDate startDate, LocalDate endDate) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        return rentalRepository.findConflictingRentals(car, startDate, endDate).isEmpty();
    }




//    @Override
//    public boolean isCarAvailable(Car carId, LocalDate startDate, LocalDate endDate) {
//        return rentalRepository.findConflictingRentals(carId, startDate, endDate).isEmpty();
//    }

    private RentalDtos.RentalResponse mapToResponse(Rental rental) {
        return RentalDtos.RentalResponse.builder()
                .rentalId(rental.getId())
                .carModel(rental.getCar().getModel())
                .userEmail(rental.getUser().getEmail())
                .startDate(rental.getStartDate())
                .endDate(rental.getEndDate())
                .status(rental.getStatus().name())
                .pickupBranch(rental.getPickupBranch() != null ? rental.getPickupBranch().getName() : null)
                .dropoffBranch(rental.getDropoffBranch() != null ? rental.getDropoffBranch().getName() : null)
                .build();
    }
}
