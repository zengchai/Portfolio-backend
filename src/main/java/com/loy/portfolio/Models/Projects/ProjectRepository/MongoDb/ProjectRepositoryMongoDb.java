package com.loy.portfolio.Models.Projects.ProjectRepository.MongoDb;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import com.loy.portfolio.Models.Projects.ProjectDO;
import com.loy.portfolio.Models.Projects.ProjectRepository.ProjectRepository;
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

    public String uploadProject(ProjectDO project) throws IOException {
        projectMongoDb.insert(project);
        return project.getTitle();
    }

    public List<ProjectDO> findAllProject() {
        Sort sortByObjectIdDesc = Sort.by(Sort.Direction.DESC, "index"); // Sorting by _id in ascending order
        return projectMongoDb.findAll(sortByObjectIdDesc);
    }

    public Optional<ProjectDO> findProjectById(String id) {
        ObjectId objectId = new ObjectId(id);
        return projectMongoDb.findById(objectId);
    }

    public Resource findFileById(String id) {
        ObjectId objectId = new ObjectId(id);

        // Query to retrieve all file metadata from the fs.files collection
        Query query = new Query(Criteria.where("_id").is(objectId));
        GridFSFile gifFile = gridFsOperations.findOne(query);
        GridFsResource gifResource = gridFsOperations.getResource(gifFile);

        return gifResource;
    }

    public void deleteFileById(String id) {
        ObjectId objectId = new ObjectId(id);

        // Query to find the file by its ObjectId
        Query query = Query.query(Criteria.where("_id").is(objectId));

        // Delete the file from GridFS
        gridFsOperations.delete(query);
    }

    public String deleteProjectById(String id) {
        ObjectId objectId = new ObjectId(id);
        projectMongoDb.deleteById(objectId);
        return (id + " successfully deleted");
    }

}
