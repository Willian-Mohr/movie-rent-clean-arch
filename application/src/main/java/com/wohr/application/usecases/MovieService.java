package com.wohr.application.usecases;

import com.wohr.domain.entities.Movie;

import java.util.Optional;

public interface MovieService {
    Movie registerMovie(Movie movie);
    Optional<Movie> findMovieById(Long id);
}
