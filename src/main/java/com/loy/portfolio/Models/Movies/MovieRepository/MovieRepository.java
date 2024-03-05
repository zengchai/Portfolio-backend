package com.loy.portfolio.Models.Movies.MovieRepository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.loy.portfolio.Models.Movies.Movie;

@Repository
public interface MovieRepository {

    List<Movie> findAll();
    Optional<Movie> findById(ObjectId id);
    Optional<Movie> findMovieByImdbId(String imdbId);

}
