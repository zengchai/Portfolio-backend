package com.loy.portfolio.Service.MovieService;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loy.portfolio.Models.Movies.Movie;
import com.loy.portfolio.Models.Movies.MovieRepository.MovieRepository;
import com.loy.portfolio.Models.Movies.MovieRepository.MongoDb.MovieMongoDb;
import com.loy.portfolio.Models.Movies.MovieRepository.MongoDb.MovieRepositoryMongoDb;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
