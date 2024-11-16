package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductDetails {

    private String name;
    private double price;

    protected ProductDetails() {
        // For JPA
    }

    public ProductDetails(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetails that = (ProductDetails) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
