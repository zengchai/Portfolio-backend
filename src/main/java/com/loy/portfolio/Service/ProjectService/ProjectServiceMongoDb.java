package com.loy.portfolio.Service.ProjectService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import com.loy.portfolio.Models.Projects.Project;
import com.loy.portfolio.Models.Projects.ProjectDO;
import com.loy.portfolio.Models.Projects.ProjectRepository.ProjectRepository;

public class ProjectServiceMongoDb implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public String uploadProject(MultipartFile video, MultipartFile image, String title, String iconName,
            List<String> technology,
            List<String> description, int index, String websiteURL, String githubURL) throws IOException {
        ProjectDO projectDAO = new ProjectDO(title, iconName, technology, description,
                projectRepository.uploadFile(video), projectRepository.uploadFile(image), index, websiteURL, githubURL);
        return projectRepository.uploadProject(projectDAO);
    }

    public List<Project> displayAllProject() {
        List<ProjectDO> projectList = projectRepository.findAllProject();
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++) {
            Project project = new Project(projectList.get(i));
            projects.add(project);
        }
        return projects;
    }

    public Resource findFileById(String id) {
        return projectRepository.findFileById(id);
    }
    
    public String deleteProjectById(String id) {
        Optional<ProjectDO> object = projectRepository.findProjectById(id);
        ProjectDO project = object.orElse(new ProjectDO());
        projectRepository.deleteFileById(project.getVideo());
        projectRepository.deleteFileById(project.getImage());
        return projectRepository.deleteProjectById(project.getId().toString());
    }
}