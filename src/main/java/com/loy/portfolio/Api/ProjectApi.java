package com.loy.portfolio.Api;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.Project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Project", description = "Project API")
public interface ProjectApi {

        @Operation(summary = "Upload a project")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully uploaded project"),
                        @ApiResponse(responseCode = "400", description = "Invalid project provided")
        })
        @PostMapping(value = "/upload")
        public ResponseEntity<String> uploadProject(
                        @RequestParam("title") String title,
                        @RequestParam("iconName") String iconName,
                        @RequestParam("websiteURL") String websiteURL,
                        @RequestParam("githubURL") String githubURL,
                        @RequestParam("technology") List<String> technology,
                        @RequestParam("description") List<String> description,
                        @RequestPart("video") MultipartFile file,
                        @RequestPart("image") MultipartFile image);

        @Operation(summary = "Upload a project")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully uploaded project"),
                        @ApiResponse(responseCode = "400", description = "Invalid project provided")
        })

        @PostMapping(value = "/list")
        public ResponseEntity<List<Project>> viewAllProject();

        @Operation(summary = "Upload a project")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully uploaded project"),
                        @ApiResponse(responseCode = "400", description = "Invalid project provided")
        })

        @PostMapping(value = "/{id}")
        public ResponseEntity<Resource> findFileById(@PathVariable String id);
}
