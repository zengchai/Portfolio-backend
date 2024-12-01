package com.loy.portfolio.Models.Skills.SkillRepository.MongoDb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Skills.SkillsDO;

public interface SkillMongoDb extends MongoRepository<SkillsDO, ObjectId> {

}
