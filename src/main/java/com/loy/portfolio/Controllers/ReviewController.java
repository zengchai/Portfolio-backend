package com.loy.portfolio.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loy.portfolio.Api.ReviewApi;
import com.loy.portfolio.Models.Reviews.Review;
import com.loy.portfolio.Service.ReviewService.ReviewService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/review")
public class ReviewController implements ReviewApi {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/reviews", produces = "application/json") // Specify the endpoint path for creating a review
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        Review createdReview = reviewService.createReview(payload.get("imdbId"), payload.get("position"),
                payload.get("company"), payload.get("review"));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }
}
