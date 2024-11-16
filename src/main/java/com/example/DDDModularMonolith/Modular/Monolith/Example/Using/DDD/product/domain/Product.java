package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.sharedkernel.domain.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {

    @Embedded
    private ProductDetails productDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    protected Product() {
        // For JPA
    }

    public Product(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}