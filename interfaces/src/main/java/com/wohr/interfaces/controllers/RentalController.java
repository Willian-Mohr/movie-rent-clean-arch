package com.wohr.interfaces.controllers;

import com.wohr.application.usecases.RentalService;
import com.wohr.domain.entities.Rental;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent")
    public Rental rent(@RequestParam Long customerId, @RequestParam Long movieId) {
        return rentalService.rentMovie(customerId, movieId);
    }

    @PostMapping("/return/{rentalId}")
    public Rental returnRental(@PathVariable Long rentalId) {
        return rentalService.returnMovie(rentalId);
    }
}