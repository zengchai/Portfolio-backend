package com.loy.portfolio.Models.Skills;

import org.bson.types.ObjectId;

public class Skills {
    private String id;
    private String name;
    private String category;
    private String subcategory;
    private String index;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Skills(String name, String category, String subcategory, String index) {
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
        this.index = index;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void fromDAO(final SkillsDO dao) {
        this.id = dao.getId().toString();
        this.name = dao.getName();
        this.category = dao.getCategory();
        this.subcategory = dao.getSubcategory();
        this.index = dao.getIndex();

    }

    public SkillsDO toDAO() {
        SkillsDO dao = new SkillsDO();
        if (this.id != null)
            dao.setId(new ObjectId(this.id));
        dao.setName(this.name);
        dao.setCategory(this.category);
        dao.setSubcategory(this.subcategory);
        dao.setIndex(this.index);
        return dao;
    }

    public Skills(final SkillsDO dao) {
        this.fromDAO(dao);
    }

}
