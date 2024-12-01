package com.loy.portfolio.Models.Projects.ProjectRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Projects.ProjectDO;

// MongoDB 
public interface ProjectMongoDb extends MongoRepository<ProjectDO, ObjectId>  {
    
}
