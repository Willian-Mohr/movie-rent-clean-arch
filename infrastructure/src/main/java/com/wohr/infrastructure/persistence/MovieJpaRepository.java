package com.wohr.infrastructure.persistence;

import com.wohr.infrastructure.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
}