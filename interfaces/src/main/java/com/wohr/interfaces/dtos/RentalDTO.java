package com.wohr.interfaces.dtos;

import java.time.LocalDate;

public class RentalDTO {
    public Long id;
    public Long customerId;
    public Long movieId;
    public LocalDate rentalDate;
    public LocalDate expectedReturnDate;
    public LocalDate actualReturnDate;
}