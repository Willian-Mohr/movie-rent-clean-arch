package com.wohr.application.services;

import com.wohr.application.usecases.RentalService;
import com.wohr.domain.entities.Customer;
import com.wohr.domain.entities.Movie;
import com.wohr.domain.entities.Rental;
import com.wohr.domain.repositories.CustomerRepository;
import com.wohr.domain.repositories.MovieRepository;
import com.wohr.domain.repositories.RentalRepository;

import java.time.LocalDate;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;

    public RentalServiceImpl(RentalRepository rentalRepository, CustomerRepository customerRepository, MovieRepository movieRepository) {
        this.rentalRepository = rentalRepository;
        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Rental rentMovie(Long customerId, Long movieId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        if (!movie.isAvailable()) {
            throw new IllegalStateException("Movie is not available");
        }

        movie.setAvailable(false);
        movieRepository.save(movie);

        Rental rental = new Rental(null, customer, movie, LocalDate.now(), LocalDate.now().plusDays(7), null);
        return rentalRepository.save(rental);
    }

    @Override
    public Rental returnMovie(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found"));

        rental.setActualReturnDate(LocalDate.now());

        Movie movie = rental.getMovie();
        movie.setAvailable(true);
        movieRepository.save(movie);

        return rentalRepository.save(rental);
    }
}