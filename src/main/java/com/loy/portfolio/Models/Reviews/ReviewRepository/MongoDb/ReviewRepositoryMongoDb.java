package com.loy.portfolio.Models.Reviews.ReviewRepository.MongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import com.loy.portfolio.Models.Movies.Movie;
import com.loy.portfolio.Models.Reviews.ReviewDAO;
import com.loy.portfolio.Models.Reviews.ReviewRepository.ReviewRepository;

public class ReviewRepositoryMongoDb implements ReviewRepository {

    @Autowired
    ReviewMongoDb reviewMongoDb;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(ReviewDAO newreview) {
        reviewMongoDb.insert(newreview);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(newreview.getName()))
                .apply(new Update().push("reviewIds", newreview))
                .first();
    }

}
