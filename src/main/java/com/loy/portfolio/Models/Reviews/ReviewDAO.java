package com.loy.portfolio.Models.Reviews;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDAO {

    @Id
    private ObjectId id;
    private String name;
    private String position;
    private String company;
    private String review;
    
    public ReviewDAO(String name, String position, String company, String review) {
        this.name = name;
        this.position = position;
        this.company = company;
        this.review = review;
    }
}
