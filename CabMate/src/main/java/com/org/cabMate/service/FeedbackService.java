package com.org.cabMate.service;


import com.org.cabMate.model.Driver;
import com.org.cabMate.model.Feedback;
import com.org.cabMate.dao.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final DriverRepository driverRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, DriverRepository driverRepository) {
        this.feedbackRepository = feedbackRepository;
        this.driverRepository = driverRepository;
    }

    public Feedback giveFeedback(Feedback feedback) {
        Driver driver = feedback.getDriver();
        driver.addRating(feedback.getRating());
        driverRepository.save(driver);
        return feedbackRepository.save(feedback);
    }
    public List<Feedback> getFeedbackForDriver(Long driverId) {
        return feedbackRepository.findByDriverId(driverId);
    }

    public List<Feedback> getFeedbackForRider(Long riderId) {
        return feedbackRepository.findByRiderId(riderId);
    }

}
