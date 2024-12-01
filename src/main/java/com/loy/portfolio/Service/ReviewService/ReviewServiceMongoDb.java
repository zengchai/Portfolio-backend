package com.loy.portfolio.Service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;

import com.loy.portfolio.Models.Reviews.Review;
import com.loy.portfolio.Models.Reviews.ReviewDO;
import com.loy.portfolio.Models.Reviews.ReviewRepository.ReviewRepository;

public class ReviewServiceMongoDb implements ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(String name, String position, String company, String review) {
        ReviewDO newreview = new ReviewDO(name, position, company, review);
        reviewRepository.insert(newreview);
        return new Review(newreview);
    }

}
