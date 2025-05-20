package com.wohr.domain.repositories;

import com.wohr.domain.entities.Movie;

import java.util.Optional;

public interface MovieRepository {
    Optional<Movie> findById(Long id);

    Movie save(Movie movie);
}