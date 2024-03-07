package com.loy.portfolio.Service.SkillService;

import java.io.IOException;
import java.util.List;

import com.loy.portfolio.Models.Skills.Skills;

public interface SkillService {
    public String uploadskills(Skills skill) throws IOException;

    public List<Skills> displayAllSkills();

}
