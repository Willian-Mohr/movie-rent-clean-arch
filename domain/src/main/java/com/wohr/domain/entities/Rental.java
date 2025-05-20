package com.wohr.domain.entities;

import java.time.LocalDate;

public class Rental {
    private Long id;
    private Customer customer;
    private Movie movie;
    private LocalDate rentalDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;

    public Rental(Long id, Customer customer, Movie movie, LocalDate rentalDate,
                  LocalDate expectedReturnDate, LocalDate actualReturnDate) {
        this.id = id;
        this.customer = customer;
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
