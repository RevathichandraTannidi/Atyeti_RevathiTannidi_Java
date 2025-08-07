package com.example.feedback.repository;

import com.example.feedback.model.FeedbackModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FeedbackRepo extends MongoRepository<FeedbackModel, String> {

    @Query("{'productId': ?0, 'rating': ?1}")
    Page<FeedbackModel> findByProductIdAndRating(String productId, int rating, Pageable pageable);
}
