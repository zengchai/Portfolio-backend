package com.loy.portfolio.Models.Skills.SkillRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Skills.SkillsDAO;

public interface SkillMongoDb extends MongoRepository<SkillsDAO, ObjectId> {

}
