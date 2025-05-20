package com.wohr.infrastructure.persistence;

import com.wohr.domain.entities.Customer;
import com.wohr.domain.repositories.CustomerRepository;
import com.wohr.infrastructure.models.CustomerEntity;

import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id).map(CustomerEntity::toDomain);
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerEntity.fromDomain(customer);
        return jpaRepository.save(entity).toDomain();
    }
}
