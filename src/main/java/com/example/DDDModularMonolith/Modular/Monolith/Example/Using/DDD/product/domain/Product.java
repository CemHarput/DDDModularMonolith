package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.sharedkernel.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Product(String name) {
        this.name = name;
    }

    protected Product() {
        // For JPA
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }
}