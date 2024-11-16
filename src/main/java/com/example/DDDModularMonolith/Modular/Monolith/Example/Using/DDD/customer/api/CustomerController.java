package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.api;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.application.CustomerService;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.dto.CustomerDto;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.dto.GetCustomerRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestParam String name) {
        CustomerDto customer = customerService.createCustomer(name);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerRequestDto> getCustomerById(@PathVariable Long id) {
        Optional<GetCustomerRequestDto> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<GetCustomerRequestDto>> getAllCustomers() {
        List<GetCustomerRequestDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
