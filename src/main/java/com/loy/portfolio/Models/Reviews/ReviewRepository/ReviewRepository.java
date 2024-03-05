package com.loy.portfolio.Models.Reviews.ReviewRepository;

import org.springframework.stereotype.Repository;

import com.loy.portfolio.Models.Reviews.ReviewDAO;

@Repository
public interface ReviewRepository {

    void insert(ReviewDAO newreview);
    
}
