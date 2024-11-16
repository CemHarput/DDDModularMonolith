package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain.Product;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.sharedkernel.domain.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    protected Customer() {
        // For JPA
    }

    public void addProduct(Product product) {
        if (products.size() >= 10) {
            throw new IllegalStateException("A customer cannot have more than 10 products.");
        }
        products.add(product);
        product.setCustomer(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCustomer(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Getters and setters
}