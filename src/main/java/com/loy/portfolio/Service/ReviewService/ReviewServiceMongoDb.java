package com.loy.portfolio.Service.ReviewService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loy.portfolio.Models.Reviews.Review;
import com.loy.portfolio.Models.Reviews.ReviewDAO;
import com.loy.portfolio.Models.Reviews.ReviewRepository.ReviewRepository;

public class ReviewServiceMongoDb implements ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(String name, String position, String company, String review) {
        ReviewDAO newreview = new ReviewDAO(name, position, company, review);
        reviewRepository.insert(newreview);
        return new Review(newreview);
    }

}
