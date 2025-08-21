package com.org.cabMate.dto;

import com.org.cabMate.model.Feedback;
import lombok.Data;

@Data
public class FeedbackDTO {
    private Long id;
    private Long tripId;
    private Long riderId;
    private Long driverId;
    private int rating;
    private String comment;
    public FeedbackDTO(Feedback feedback) {
        this.id = feedback.getId();
        this.tripId = feedback.getTrip().getId();
        this.riderId = feedback.getRider().getId();
        this.driverId = feedback.getDriver().getId();
        this.rating = feedback.getRating();
        this.comment = feedback.getComment();
    }
}

