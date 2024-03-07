package com.loy.portfolio.Api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.Project;
import com.loy.portfolio.Models.Skills.Skills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Skill", description = "Skill API")
public interface SkillApi {
    @Operation(summary = "Upload a skill")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully uploaded skill"),
            @ApiResponse(responseCode = "400", description = "Invalid skill provided")
    })
    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadProject(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("subcategory") String subcategory,
            @RequestParam("index") String index);

    @Operation(summary = "View all skills")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully viewed all skills"),
            @ApiResponse(responseCode = "400", description = "Coudn't fetch the skills")
    })
    @PostMapping(value = "/list")
    public ResponseEntity<List<Skills>> viewAllSkill();

}
