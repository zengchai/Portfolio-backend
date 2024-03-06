package com.loy.portfolio.Models.Projects.ProjectRepository.MongoDb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.ProjectDAO;
import com.loy.portfolio.Models.Projects.ProjectRepository.ProjectRepository;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

public class ProjectRepositoryMongoDb implements ProjectRepository {

    @Autowired
    ProjectMongoDb projectMongoDb;

    @Autowired
    private GridFsOperations gridFsOperations;

    public String uploadFile(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();

        return gridFsOperations.store(inputStream, fileName, contentType).toString();
    }

    public String uploadProject(ProjectDAO project) throws IOException {
        projectMongoDb.insert(project);
        return project.getTitle();
    }

    public List<ProjectDAO> findAllProject() {
        Sort sortByObjectIdAsc = Sort.by(Sort.Direction.DESC, "_id"); // Sorting by _id in ascending order
        return projectMongoDb.findAll(sortByObjectIdAsc);
    }

    public Resource findFileById(ObjectId id) {

        // Query to retrieve all file metadata from the fs.files collection
        Query query = new Query(Criteria.where("_id").is(id));
        GridFSFile gifFile = gridFsOperations.findOne(query);
        GridFsResource gifResource = gridFsOperations.getResource(gifFile);

        return gifResource;
    }

}
