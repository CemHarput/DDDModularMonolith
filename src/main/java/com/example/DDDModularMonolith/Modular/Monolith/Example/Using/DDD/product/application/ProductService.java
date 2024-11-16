package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.application;


import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.domain.Customer;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.infrastructure.CustomerRepository;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain.Product;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.dto.ProductDto;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.infrastructure.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ProductService(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public ProductDto addProductToCustomer(Long customerId, String productName) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = new Product(productName);
        customer.addProduct(product);
        Product savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct.getName());
    }
}
