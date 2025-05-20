package com.wohr.domain.repositories;

import com.wohr.domain.entities.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);

    Customer save(Customer customer);
}