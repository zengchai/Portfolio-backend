package com.loy.portfolio.Models.Reviews.ReviewRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Reviews.ReviewDAO;

public interface ReviewMongoDb extends MongoRepository<ReviewDAO, ObjectId> {

}
