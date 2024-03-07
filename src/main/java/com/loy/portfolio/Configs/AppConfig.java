package com.loy.portfolio.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loy.portfolio.Models.Projects.ProjectRepository.ProjectRepository;
import com.loy.portfolio.Models.Projects.ProjectRepository.MongoDb.ProjectRepositoryMongoDb;
import com.loy.portfolio.Models.Reviews.ReviewRepository.ReviewRepository;
import com.loy.portfolio.Models.Reviews.ReviewRepository.MongoDb.ReviewRepositoryMongoDb;
import com.loy.portfolio.Models.Skills.SkillRepository.SkillRepository;
import com.loy.portfolio.Models.Skills.SkillRepository.MongoDb.SkillRepositoryMongoDb;
import com.loy.portfolio.Service.ProjectService.ProjectService;
import com.loy.portfolio.Service.ProjectService.ProjectServiceMongoDb;
import com.loy.portfolio.Service.ReviewService.ReviewService;
import com.loy.portfolio.Service.ReviewService.ReviewServiceMongoDb;
import com.loy.portfolio.Service.SkillService.SkillService;
import com.loy.portfolio.Service.SkillService.SkillServiceMongoDb;

@Configuration
public class AppConfig {

    @Bean
    ReviewRepository reviewRepository() {
        return new ReviewRepositoryMongoDb();
    }

    @Bean
    ReviewService reviewService() {
        return new ReviewServiceMongoDb();
    }

    @Bean
    ProjectRepository projectRepository() {
        return new ProjectRepositoryMongoDb();
    }

    @Bean
    ProjectService projectService() {
        return new ProjectServiceMongoDb();
    }

    
    @Bean
    SkillRepository skillRepository() {
        return new SkillRepositoryMongoDb();
    }

    @Bean
    SkillService skillService() {
        return new SkillServiceMongoDb();
    }


}
