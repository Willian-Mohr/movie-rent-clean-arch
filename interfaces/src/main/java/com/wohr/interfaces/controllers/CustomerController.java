package com.wohr.interfaces.controllers;

import com.wohr.application.usecases.CustomerService;
import com.wohr.domain.entities.Customer;
import com.wohr.interfaces.dtos.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody CustomerDTO dto) {
        return customerService.registerCustomer(new Customer(dto.id, dto.name, dto.cpf));
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return customerService.findCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
