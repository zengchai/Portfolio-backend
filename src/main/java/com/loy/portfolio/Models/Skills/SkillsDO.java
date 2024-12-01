package com.loy.portfolio.Models.Skills;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Document(collection = "skills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillsDO {
    @Id
    private ObjectId id;
    private String name;
    private String category;
    private String subcategory;
    private String index;

    public SkillsDO(String name, String category, String subcategory, String index) {
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
        this.index = index;
    }
}
