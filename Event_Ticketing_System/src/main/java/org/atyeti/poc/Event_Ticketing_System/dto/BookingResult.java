package org.atyeti.poc.Event_Ticketing_System.dto;

import lombok.Data;

@Data
public class BookingResult {
    private String userId;
    private String status;
    private String seatId;

    public BookingResult(String userId, String status, String seatId) {
        this.userId = userId;
        this.status = status;
        this.seatId = seatId;
    }

    public BookingResult() {
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public String getSeatId() {
        return seatId;
    }
}
