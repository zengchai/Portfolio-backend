package com.loy.portfolio.Models.Projects;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Document(collection = "project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDO {

    @Id
    private ObjectId id;
    private String title;
    private String iconName;
    private List<String> technology;
    private List<String> description;
    private String video;
    private String image;
    private int index;
    private String websiteURL;
    private String githubURL;

    public ProjectDO(String title, String iconName, List<String> technology, List<String> description, String video,
            String image, int index, String websiteURL, String githubURL) {
        this.title = title;
        this.iconName = iconName;
        this.technology = technology;
        this.description = description;
        this.video = video;
        this.image = image;
        this.index = index;
        this.websiteURL = websiteURL;
        this.githubURL = githubURL;
    }

}
