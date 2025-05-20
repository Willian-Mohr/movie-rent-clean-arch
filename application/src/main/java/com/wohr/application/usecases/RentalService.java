package com.wohr.application.usecases;

import com.wohr.domain.entities.Rental;

public interface RentalService {
    Rental rentMovie(Long customerId, Long movieId);
    Rental returnMovie(Long rentalId);
}
