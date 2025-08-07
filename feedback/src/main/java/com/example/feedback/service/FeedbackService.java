package com.example.feedback.service;

import com.example.feedback.model.FeedbackModel;
import com.example.feedback.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    public FeedbackModel submitFeedback(FeedbackModel feedbackModel) {
        return feedbackRepo.save(feedbackModel);
    }

    public Page<FeedbackModel> getFeedbackByProductIdAndRating(String productId, int rating, int page) {
        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size);
        return feedbackRepo.findByProductIdAndRating(productId, rating, pageRequest);
    }
}
