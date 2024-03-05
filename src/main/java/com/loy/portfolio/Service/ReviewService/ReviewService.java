package com.loy.portfolio.Service.ReviewService;

import org.springframework.stereotype.Service;

import com.loy.portfolio.Models.Reviews.Review;


public interface ReviewService {

    public Review createReview(String name, String position, String company, String review);
    
}
