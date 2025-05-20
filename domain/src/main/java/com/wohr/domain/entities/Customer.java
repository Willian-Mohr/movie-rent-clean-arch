package com.wohr.domain.entities;

public class Customer {
    private Long id;
    private String name;
    private String cpf;

    public Customer(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCpf() { return cpf; }
}