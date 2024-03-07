package com.loy.portfolio.Models.Skills.SkillRepository;

import java.io.IOException;
import java.util.List;

import com.loy.portfolio.Models.Skills.SkillsDAO;

public interface SkillRepository {

    public List<SkillsDAO> findAllSkill();

    public String uploadSkill(SkillsDAO skill) throws IOException;

}
