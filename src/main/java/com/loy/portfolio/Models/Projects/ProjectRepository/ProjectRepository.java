package com.loy.portfolio.Models.Projects.ProjectRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.ProjectDO;

public interface ProjectRepository {

    public String uploadFile(MultipartFile file) throws IOException;
    public String uploadProject(ProjectDO project) throws IOException;
    public List<ProjectDO> findAllProject();
    public Optional<ProjectDO> findProjectById(String id);
    public Resource findFileById(String id);
    public void deleteFileById(String id);
    public String deleteProjectById(String id);

}
