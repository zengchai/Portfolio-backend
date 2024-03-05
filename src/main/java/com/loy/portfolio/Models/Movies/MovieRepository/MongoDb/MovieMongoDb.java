package com.loy.portfolio.Models.Movies.MovieRepository.MongoDb;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Movies.Movie;
import java.util.List;

public interface MovieMongoDb extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieByImdbId(String imdbId);
}
