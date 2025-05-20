package com.wohr.infrastructure.persistence;

import com.wohr.domain.entities.Movie;
import com.wohr.domain.repositories.MovieRepository;
import com.wohr.infrastructure.models.MovieEntity;

import java.util.Optional;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieJpaRepository jpaRepository;

    public MovieRepositoryImpl(MovieJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return jpaRepository.findById(id).map(MovieEntity::toDomain);
    }

    @Override
    public Movie save(Movie movie) {
        MovieEntity entity = MovieEntity.fromDomain(movie);
        return jpaRepository.save(entity).toDomain();
    }
}
