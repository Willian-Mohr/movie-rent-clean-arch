package com.wohr.infrastructure.models;

import com.wohr.domain.entities.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerEntity {

    @Id
    private Long id;
    private String name;
    private String cpf;

    public static CustomerEntity fromDomain(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getId());
        entity.setName(customer.getName());
        entity.setCpf(customer.getCpf());
        return entity;
    }

    public Customer toDomain() {
        return new Customer(id, name, cpf);
    }
}
