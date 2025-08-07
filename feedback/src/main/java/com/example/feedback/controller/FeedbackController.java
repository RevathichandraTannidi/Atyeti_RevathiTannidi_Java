package com.example.feedback.controller;

import com.example.feedback.model.FeedbackModel;
import com.example.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackModel submitFeedback(@RequestBody FeedbackModel feedbackModel) {
        return feedbackService.submitFeedback(feedbackModel);
    }

    @GetMapping("/product/{productId}/rating/{rating}")
    public List<FeedbackModel> getFeedbackByProductIdAndRating(
            @PathVariable String productId,
            @PathVariable int rating,
            @RequestParam(defaultValue = "0") int page) {

        return feedbackService.getFeedbackByProductIdAndRating(productId, rating, page).getContent();
    }
}
