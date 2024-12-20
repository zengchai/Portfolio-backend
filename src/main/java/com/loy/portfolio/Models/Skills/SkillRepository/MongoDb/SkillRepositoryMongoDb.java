package com.loy.portfolio.Models.Skills.SkillRepository.MongoDb;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.loy.portfolio.Models.Skills.SkillsDO;
import com.loy.portfolio.Models.Skills.SkillRepository.SkillRepository;

public class SkillRepositoryMongoDb implements SkillRepository {

    @Autowired
    SkillMongoDb skillMongoDb;

    public List<SkillsDO> findAllSkill() {
        Sort sortByObjectIdDesc = Sort.by(Sort.Direction.DESC, "index"); // Sorting by _id in ascending order
        return skillMongoDb.findAll(sortByObjectIdDesc);
    }

    public String uploadSkill(SkillsDO skill) throws IOException {
        skillMongoDb.insert(skill);
        return skill.getName();
    }

}
