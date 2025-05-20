package com.wohr.infrastructure.persistence;

import com.wohr.domain.entities.Rental;
import com.wohr.domain.repositories.RentalRepository;
import com.wohr.infrastructure.models.RentalEntity;

import java.util.Optional;

public class RentalRepositoryImpl implements RentalRepository {

    private final RentalJpaRepository jpaRepository;

    public RentalRepositoryImpl(RentalJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return jpaRepository.findById(id).map(RentalEntity::toDomain);
    }

    @Override
    public Rental save(Rental rental) {
        RentalEntity entity = RentalEntity.fromDomain(rental);
        return jpaRepository.save(entity).toDomain();
    }
}
