package com.loy.portfolio.Models.Reviews.ReviewRepository.MongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.loy.portfolio.Models.Reviews.ReviewDO;
import com.loy.portfolio.Models.Reviews.ReviewRepository.ReviewRepository;

public class ReviewRepositoryMongoDb implements ReviewRepository {

    @Autowired
    ReviewMongoDb reviewMongoDb;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(ReviewDO newreview) {
        reviewMongoDb.insert(newreview);
        
    }

}
