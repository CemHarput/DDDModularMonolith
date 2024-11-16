package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.infrastructure;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
