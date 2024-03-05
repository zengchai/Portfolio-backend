package com.loy.portfolio.Models.User.UserRepository.MongoDb;

import org.springframework.beans.factory.annotation.Autowired;

import com.loy.portfolio.Models.User.UserRepository.UserRepository;

public class UserRepositoryMongoDb implements UserRepository {
    
    @Autowired
    private UserMongoDb userMongoDb;

    
}
