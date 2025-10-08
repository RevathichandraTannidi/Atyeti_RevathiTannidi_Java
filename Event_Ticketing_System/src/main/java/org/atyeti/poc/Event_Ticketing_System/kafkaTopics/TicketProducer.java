package org.atyeti.poc.Event_Ticketing_System.kafkaTopics;

import org.atyeti.poc.Event_Ticketing_System.dto.BookingRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketProducer {

    private final KafkaTemplate<String, BookingRequest> producer;

    public TicketProducer(KafkaTemplate<String, BookingRequest> producer) {
        this.producer = producer;
    }

    public void sendBookingRequest(BookingRequest request) {
        producer.send("ticket.requested", request.getEventId(), request);
        System.out.println("Sent booking request to topic 'ticket.requested' for user: " + request.getUserId());
    }

    public void sendToWaitingList(BookingRequest request) {
        producer.send("ticket.waiting", request.getEventId(), request);
        System.out.println(" Sent booking to waiting list topic 'ticket.waiting' for user: " + request.getUserId());
    }


    public void sendBookingFailed(BookingRequest request) {
        producer.send("ticket.failed", request.getEventId(), request);
        System.out.println(" Sent booking failed message to topic 'ticket.failed' for user: " + request.getUserId());
    }
}
