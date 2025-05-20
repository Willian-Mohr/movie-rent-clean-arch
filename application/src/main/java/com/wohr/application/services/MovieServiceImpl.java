package com.wohr.application.services;

import com.wohr.application.usecases.MovieService;
import com.wohr.domain.entities.Movie;
import com.wohr.domain.repositories.MovieRepository;

import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie registerMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id);
    }
}
