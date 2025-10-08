package org.atyeti.poc.Event_Ticketing_System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @Column(name = "seat_id")
    private String seatId = java.util.UUID.randomUUID().toString();

    private String eventId;
    private String status;
    private String bookedBy;

    public String getSeatId() {
        return seatId;
    }
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookedBy() {
        return bookedBy;
    }
    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
}
