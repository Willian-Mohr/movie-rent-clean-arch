package com.wohr.domain.repositories;

import com.wohr.domain.entities.Rental;

import java.util.Optional;

public interface RentalRepository {
    Optional<Rental> findById(Long id);

    Rental save(Rental rental);
}