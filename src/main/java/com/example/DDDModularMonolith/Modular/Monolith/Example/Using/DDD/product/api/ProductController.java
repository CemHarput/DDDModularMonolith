package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.api;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.application.ProductService;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.domain.Product;
import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProductToCustomer(
            @RequestParam Long customerId,
            @RequestParam String productName) {
        ProductDto product = productService.addProductToCustomer(customerId, productName);
        return ResponseEntity.ok(product);
    }
}