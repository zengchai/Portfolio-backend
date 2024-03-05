package com.loy.portfolio.Service.ProjectService;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.Project;

public interface ProjectService {
    public String uploadProject(MultipartFile file, String title, String iconName, List<String> technology,
            List<String> description, String websiteURL, String githubURL) throws IOException;

    public List<Project> displayAllProject();

    public Resource displayGif(String id);

}
