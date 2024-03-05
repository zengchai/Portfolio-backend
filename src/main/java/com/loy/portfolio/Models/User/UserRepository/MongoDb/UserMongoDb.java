package com.loy.portfolio.Models.User.UserRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.User.User;

public interface UserMongoDb extends MongoRepository<User, ObjectId> {
    
}
