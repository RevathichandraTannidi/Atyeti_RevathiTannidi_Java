package org.atyeti.java.service;


import org.atyeti.java.model.Passenger;

import java.util.List;
import java.util.concurrent.Callable;

public class BookingTask implements Callable<String> {

    private List<Passenger> passengers;
    private BookingService bookingService;

    public BookingTask(List<Passenger> passengers) {
        this.passengers = passengers;
        this.bookingService = new BookingService();
    }

    @Override
    public String call() {
        return bookingService.bookRandomSeats(passengers);
    }
}
