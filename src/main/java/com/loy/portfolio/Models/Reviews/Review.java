package com.loy.portfolio.Models.Reviews;

import org.bson.types.ObjectId;

public class Review {
    private String id;
    private String name;
    private String position;
    private String company;
    private String review;

    public Review(String name, String position, String company, String review) {
        this.name = name;
        this.position = position;
        this.company = company;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void fromDAO(final ReviewDO dao) {
        this.id = dao.getId().toString();
        this.name = dao.getName();
        this.position = dao.getPosition();
        this.company = dao.getCompany();
        this.review = dao.getReview();

    }

    public ReviewDO toDAO() {
        ReviewDO dao = new ReviewDO();
        if (this.id != null)
            dao.setId(new ObjectId(this.id));
            dao.setName(this.name);
            dao.setPosition(this.position);
            dao.setReview(this.review);
        return dao;
    }

    public Review(final ReviewDO dao){
            this.fromDAO(dao);
        }
}
