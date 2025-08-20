package com.org.cabMate.controllers;

import com.org.cabMate.dto.FeedbackDTO;
import com.org.cabMate.model.Feedback;
import com.org.cabMate.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public FeedbackDTO giveFeedback(@RequestBody Feedback feedback) {
        return new FeedbackDTO(feedbackService.giveFeedback(feedback));
    }

    @GetMapping("/driver/{driverId}")
    public List<FeedbackDTO> getDriverFeedback(@PathVariable Long driverId) {
        return feedbackService.getFeedbackForDriver(driverId)
                .stream()
                .map(FeedbackDTO::new)
                .toList();
    }

    @GetMapping("/rider/{riderId}")
    public List<FeedbackDTO> getRiderFeedback(@PathVariable Long riderId) {
        return feedbackService.getFeedbackForRider(riderId)
                .stream()
                .map(FeedbackDTO::new)
                .toList();
    }
}
