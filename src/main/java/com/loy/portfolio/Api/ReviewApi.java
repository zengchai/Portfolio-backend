package com.loy.portfolio.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loy.portfolio.Models.Reviews.Review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@Tag(name = "Review", description = "Review API")
public interface ReviewApi {

    @Operation(summary = "Create a new review", description = "Create a new review based on the provided payload")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created review", content = @Content(examples = {
                    @ExampleObject(value = "{\"id\": \"String\",\"name\": \"String\", \"position\": \"String\", \"company\": \"String\", \"review\": \"String\"}") })),
            @ApiResponse(responseCode = "400", description = "Invalid payload provided")
    })
    ResponseEntity<Review> createReview(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The payload for creating a new review", required = true, content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(value = "{\"imdbId\": \"String\", \"position\": \"String\", \"company\": \"String\", \"review\": \"String\"}") })) @RequestBody Map<String, String> payload);
}
