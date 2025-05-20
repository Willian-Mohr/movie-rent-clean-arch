package com.wohr.infrastructure.models;

import com.wohr.domain.entities.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieEntity {

    @Id
    private Long id;

    private String title;
    private String genre;
    private int releaseYear;
    private boolean available;

    public static MovieEntity fromDomain(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setTitle(movie.getTitle());
        entity.setGenre(movie.getGenre());
        entity.setReleaseYear(movie.getReleaseYear());
        entity.setAvailable(movie.isAvailable());
        return entity;
    }

    public Movie toDomain() {
        return new Movie(id, title, genre, releaseYear, available);
    }
}