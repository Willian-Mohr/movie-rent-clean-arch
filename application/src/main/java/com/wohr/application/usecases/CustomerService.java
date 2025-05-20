package com.wohr.application.usecases;

import com.wohr.domain.entities.Customer;
import java.util.Optional;

public interface CustomerService {
    Customer registerCustomer(Customer customer);
    Optional<Customer> findCustomerById(Long id);
}
