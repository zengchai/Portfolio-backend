package com.loy.portfolio.Service.ProjectService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loy.portfolio.Models.Projects.Project;
import com.loy.portfolio.Models.Projects.ProjectDAO;
import com.loy.portfolio.Models.Projects.ProjectRepository.ProjectRepository;

public class ProjectServiceMongoDb implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String uploadProject(MultipartFile file, String title, String iconName, List<String> technology,
            List<String> description, String websiteURL, String githubURL) throws IOException {
        ProjectDAO projectDAO = new ProjectDAO(title, iconName, technology, description,
                projectRepository.uploadGif(file), websiteURL, githubURL);
        return projectRepository.uploadProject(projectDAO);
    }

    public List<Project> displayAllProject() {
        List<ProjectDAO> projectList = projectRepository.findAllProject();
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++) {
            Project project = new Project(projectList.get(i));
            projects.add(project);
        }
        return projects;
    }

    public Resource displayGif(String id) {
        ObjectId objectId = new ObjectId(id);
        return projectRepository.findGifById(objectId);
    }
}