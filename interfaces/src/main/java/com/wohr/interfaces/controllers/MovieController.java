package com.wohr.interfaces.controllers;

import com.wohr.application.usecases.MovieService;
import com.wohr.domain.entities.Movie;
import com.wohr.interfaces.dtos.MovieDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie create(@RequestBody MovieDTO dto) {
        return movieService.registerMovie(new Movie(dto.id, dto.title, dto.genre, dto.releaseYear, true));
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable Long id) {
        return movieService.findMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}