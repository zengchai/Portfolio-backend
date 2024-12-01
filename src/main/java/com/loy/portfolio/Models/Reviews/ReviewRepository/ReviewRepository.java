package com.loy.portfolio.Models.Reviews.ReviewRepository;

import org.springframework.stereotype.Repository;

import com.loy.portfolio.Models.Reviews.ReviewDO;

@Repository
public interface ReviewRepository {

    void insert(ReviewDO newreview);
    
}
