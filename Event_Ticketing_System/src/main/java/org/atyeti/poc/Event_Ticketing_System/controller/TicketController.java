package org.atyeti.poc.Event_Ticketing_System.controller;

import org.atyeti.poc.Event_Ticketing_System.dto.BookingRequest;
import org.atyeti.poc.Event_Ticketing_System.entity.Booking;
import org.atyeti.poc.Event_Ticketing_System.kafkaTopics.TicketProducer;
import org.atyeti.poc.Event_Ticketing_System.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketProducer producer;
    private final BookingRepository bookingRepository;

    public TicketController(TicketProducer producer, BookingRepository bookingRepository) {
        this.producer = producer;
        this.bookingRepository = bookingRepository;
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody BookingRequest request) {
        producer.sendBookingRequest(request);
        return ResponseEntity.ok("Booking request submitted for user " + request.getUserId());
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}

