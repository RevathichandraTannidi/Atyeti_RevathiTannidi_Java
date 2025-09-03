package org.atyeti.car_rental_system.car.service;

import org.atyeti.car_rental_system.car.dtos.RentalDtos;
import java.time.LocalDate;
import java.util.List;

public interface RentalService {

    RentalDtos.RentalResponse bookRental(RentalDtos.RentalRequest request);

    RentalDtos.RentalResponse cancelRental(Long rentalId);


    RentalDtos.RentalResponse extendRental(Long rentalId, LocalDate newEndDate);

    List<RentalDtos.RentalResponse> getUserRentals(Long userId);

    boolean isCarAvailable(Long carId, LocalDate startDate, LocalDate endDate);
}
