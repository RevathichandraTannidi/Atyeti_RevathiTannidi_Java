package org.atyeti.poc.Event_Ticketing_System.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private String userId;
    private String eventId;
    private String seatId;

    public String getUserId() {
        return userId;
    }

    public BookingRequest() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
