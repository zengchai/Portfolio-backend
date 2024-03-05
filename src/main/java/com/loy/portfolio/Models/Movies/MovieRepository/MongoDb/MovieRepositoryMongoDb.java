package com.loy.portfolio.Models.Movies.MovieRepository.MongoDb;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.loy.portfolio.Models.Movies.Movie;
import com.loy.portfolio.Models.Movies.MovieRepository.MovieRepository;

public class MovieRepositoryMongoDb implements MovieRepository {

    @Autowired
    MovieMongoDb movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
