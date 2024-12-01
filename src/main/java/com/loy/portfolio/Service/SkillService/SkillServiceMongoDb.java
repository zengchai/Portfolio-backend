package com.loy.portfolio.Service.SkillService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loy.portfolio.Models.Skills.Skills;
import com.loy.portfolio.Models.Skills.SkillsDO;
import com.loy.portfolio.Models.Skills.SkillRepository.SkillRepository;

public class SkillServiceMongoDb implements SkillService {

    @Autowired
    SkillRepository skillRepository;

    public String uploadskills(Skills skill) throws IOException {
        SkillsDO skillsDAO = skill.toDAO();
        return skillRepository.uploadSkill(skillsDAO);
    }

    public List<Skills> displayAllSkills() {
        List<SkillsDO> skillList = skillRepository.findAllSkill();
        List<Skills> skills = new ArrayList<>();
        for (int i = 0; i < skillList.size(); i++) {
            Skills skill = new Skills(skillList.get(i));
            skills.add(skill);
        }
        return skills;
    }

}
