package com.wohr.infrastructure.persistence;

import com.wohr.infrastructure.models.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalJpaRepository extends JpaRepository<RentalEntity, Long> {
}