package org.atyeti.poc.Event_Ticketing_System.kafkaTopics;

import org.atyeti.poc.Event_Ticketing_System.dto.BookingRequest;
import org.atyeti.poc.Event_Ticketing_System.entity.Booking;
import org.atyeti.poc.Event_Ticketing_System.repository.BookingRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketConsumer {

    private final BookingRepository bookingRepository;

    public TicketConsumer(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @KafkaListener(topics = "ticket.requested", groupId = "booking-group")
    public void processBooking(BookingRequest request) {
        try {
            System.out.println(" Processing booking request for event " + request.getEventId() + ", seat " + request.getSeatId());


            boolean isSeatAvailable = Math.random() > 0.2;
            if (isSeatAvailable) {
                Booking booking = new Booking();
                booking.setUserId(request.getUserId());
                booking.setEventId(request.getEventId());
                booking.setSeatId(request.getSeatId());
                booking.setStatus("CONFIRMED");
                booking.setBookedAt(LocalDateTime.now());
                bookingRepository.save(booking);
                System.out.println("Booking confirmed for " + request.getUserId());
            } else {

                System.out.println(" No seats available, adding to waiting list");

            }
        } catch (Exception e) {
            System.err.println(" Booking failed for " + request.getUserId() + ": " + e.getMessage());

        }
    }

    @KafkaListener(topics = "ticket.waiting", groupId = "waiting-group")
    public void processWaitingList(BookingRequest request) {
        System.out.println(" Processing waiting list for user " + request.getUserId() + ", event " + request.getEventId());
    }

    @KafkaListener(topics = "ticket.failed", groupId = "failed-group")
    public void processFailedBookings(BookingRequest request) {
        System.out.println(" Booking failed for user " + request.getUserId() + " on event " + request.getEventId());
    }
}
