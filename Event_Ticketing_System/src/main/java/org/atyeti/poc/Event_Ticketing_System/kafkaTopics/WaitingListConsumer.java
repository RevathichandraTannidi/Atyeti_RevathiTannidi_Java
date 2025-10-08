package org.atyeti.poc.Event_Ticketing_System.kafkaTopics;

import jakarta.transaction.Transactional;
import org.atyeti.poc.Event_Ticketing_System.dto.*;
import org.atyeti.poc.Event_Ticketing_System.entity.*;
import org.atyeti.poc.Event_Ticketing_System.repository.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class WaitingListConsumer {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final KafkaTemplate<String, BookingResult> resultProducer;

    public WaitingListConsumer(SeatRepository seatRepository,
                               BookingRepository bookingRepository,
                               KafkaTemplate<String, BookingResult> resultProducer) {
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.resultProducer = resultProducer;
    }

    @KafkaListener(topics = "ticket.waiting", groupId = "waiting-group")
    @Transactional
    public void processWaitingList(BookingRequest request) {
        Optional<Seat> seatOpt = seatRepository.findBySeatIdAndStatus(request.getSeatId(), "available");
        if (seatOpt.isPresent()) {
            Seat seat = seatOpt.get();
            seat.setStatus("booked");
            seat.setBookedBy(request.getUserId());
            seatRepository.save(seat);

            Booking booking = new Booking();
            booking.setBookingId(UUID.randomUUID().toString());
            booking.setUserId(request.getUserId());
            booking.setEventId(request.getEventId());
            booking.setSeatId(request.getSeatId());
            booking.setStatus("CONFIRMED");
            booking.setBookedAt(LocalDateTime.now());
            bookingRepository.save(booking);

            resultProducer.send("ticket.confirmed", new BookingResult(request.getUserId(), "CONFIRMED", request.getSeatId()));
        }
    }
}
