package com.loy.portfolio.Models.Skills.SkillRepository;

import java.io.IOException;
import java.util.List;

import com.loy.portfolio.Models.Skills.SkillsDO;

public interface SkillRepository {

    public List<SkillsDO> findAllSkill();

    public String uploadSkill(SkillsDO skill) throws IOException;

}
