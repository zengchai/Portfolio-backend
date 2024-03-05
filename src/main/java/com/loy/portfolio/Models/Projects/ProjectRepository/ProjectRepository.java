package com.loy.portfolio.Models.Projects.ProjectRepository;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.ProjectDAO;

public interface ProjectRepository {

    public String uploadGif(MultipartFile file) throws IOException;

    public String uploadProject(ProjectDAO project) throws IOException;

    public List<ProjectDAO> findAllProject();

    public Resource findGifById(ObjectId id);


}
