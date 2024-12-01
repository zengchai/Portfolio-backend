package com.loy.portfolio.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Api.ProjectApi;
import com.loy.portfolio.Models.Projects.Project;
import com.loy.portfolio.Service.ProjectService.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/project")
public class ProjectController implements ProjectApi {

    @Autowired
    ProjectService projectService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadProject(
            @RequestParam("title") String title,
            @RequestParam("iconName") String iconName,
            @RequestParam("websiteURL") String websiteURL,
            @RequestParam("githubURL") String githubURL,
            @RequestParam("technology") List<String> technology,
            @RequestParam("description") List<String> description,
            @RequestParam("index") int index,
            @RequestPart("video") MultipartFile video,
            @RequestPart("image") MultipartFile image) {
        try {
            String fileName = projectService.uploadProject(video, image, title, iconName,
                    technology, description, index, websiteURL,
                    githubURL);
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Project>> viewAllProject() {
        return new ResponseEntity<List<Project>>(projectService.displayAllProject(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource> findFileById(@PathVariable String id) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(projectService.findFileById(id));
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable String id) {
        return ResponseEntity.ok("Project deleted successfully: " + projectService.deleteProjectById(id));
    }
}
