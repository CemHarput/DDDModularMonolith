package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.application;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.dto.CustomerDto;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.dto.GetCustomerRequestDto;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.infrastructure.CustomerRepository;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.dto.ProductDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto createCustomer(String name) {
        Customer customer = new Customer(name);
        customerRepository.save(customer);
        return new CustomerDto(customer.getName());
    }

    public Optional<GetCustomerRequestDto> getCustomerById(Long id) {
        return customerRepository.findById(id) // Use repository's built-in findById method
                .map(this::mapToGetCustomerRequestDto); // Map Customer to GetCustomerRequestDto
    }
    public List<GetCustomerRequestDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToGetCustomerRequestDto)
                .toList();
    }

    private GetCustomerRequestDto mapToGetCustomerRequestDto(Customer customer) {
        List<ProductDto> productDtos = customer.getProducts().stream()
                .map(product -> new ProductDto(product.getProductDetails().getName(),product.getProductDetails().getPrice()))
                .toList();

        return new GetCustomerRequestDto(
                customer.getName(),
                productDtos,
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }
}
