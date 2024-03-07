package com.loy.portfolio.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Api.SkillApi;
import com.loy.portfolio.Models.Projects.Project;
import com.loy.portfolio.Models.Skills.Skills;
import com.loy.portfolio.Service.SkillService.SkillService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/skills")
public class SkillController implements SkillApi {

    @Autowired
    SkillService skillService;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadProject(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("subcategory") String subcategory,
            @RequestParam("index") String index) {
        try {
            Skills skill = new Skills(name, category, subcategory, index);
            String fileName = skillService.uploadskills(skill);
            return ResponseEntity.ok("Skill uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading skill");
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Skills>> viewAllSkill() {
        return new ResponseEntity<List<Skills>>(skillService.displayAllSkills(), HttpStatus.OK);

    }
}
