package com.wohr.infrastructure.models;

import com.wohr.domain.entities.Rental;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class RentalEntity {

    @Id
    private Long id;

    @ManyToOne
    private CustomerEntity customer;

    @ManyToOne
    private MovieEntity movie;

    private LocalDate rentalDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;

    public static RentalEntity fromDomain(Rental rental) {
        RentalEntity entity = new RentalEntity();
        entity.setId(rental.getId());
        entity.setCustomer(CustomerEntity.fromDomain(rental.getCustomer()));
        entity.setMovie(MovieEntity.fromDomain(rental.getMovie()));
        entity.setRentalDate(rental.getRentalDate());
        entity.setExpectedReturnDate(rental.getExpectedReturnDate());
        entity.setActualReturnDate(rental.getActualReturnDate());
        return entity;
    }

    public Rental toDomain() {
        return new Rental(id,
                customer.toDomain(),
                movie.toDomain(),
                rentalDate,
                expectedReturnDate,
                actualReturnDate);
    }
}
