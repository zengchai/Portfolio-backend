package com.loy.portfolio.Models.Projects;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.core.io.Resource;

public class Project {

    private String id;
    private String title;
    private String iconName;
    private List<String> technology;
    private List<String> description;
    private String video;
    private String image;
    private int index;
    private String websiteURL;
    private String githubURL;

    public Project(String id, String title, String iconName, List<String> technology, List<String> description,
            String video, String image, int index, String websiteURL, String githubURL) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public List<String> getTechnology() {
        return technology;
    }

    public void setTechnology(List<String> technology) {
        this.technology = technology;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getGithubURL() {
        return githubURL;
    }

    public void setGithubURL(String githubURL) {
        this.githubURL = githubURL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void fromDAO(final ProjectDAO dao) {
        this.id = dao.getId().toString();
        this.title = dao.getTitle();
        this.iconName = dao.getIconName();
        this.video = dao.getVideo();
        this.image = dao.getImage();
        this.index = dao.getIndex();
        this.technology = dao.getTechnology();
        this.description = dao.getDescription();
        this.websiteURL = dao.getWebsiteURL();
        this.githubURL = dao.getGithubURL();

    }

    public ProjectDAO toDAO() {
        ProjectDAO dao = new ProjectDAO();
        if (this.id != null)
            dao.setId(new ObjectId(this.id));
        dao.setTitle(this.title);
        dao.setIconName(this.iconName);
        dao.setTechnology(this.technology);
        dao.setDescription(this.description);
        dao.setIndex(this.index);
        dao.setWebsiteURL(this.websiteURL);
        dao.setGithubURL(this.githubURL);
        return dao;
    }

    public Project(final ProjectDAO dao) {
        this.fromDAO(dao);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
