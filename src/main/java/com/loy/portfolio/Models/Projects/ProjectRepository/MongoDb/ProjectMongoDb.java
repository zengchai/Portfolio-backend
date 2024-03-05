package com.loy.portfolio.Models.Projects.ProjectRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Projects.ProjectDAO;

public interface ProjectMongoDb extends MongoRepository<ProjectDAO, ObjectId>  {
    
}
