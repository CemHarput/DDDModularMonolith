package com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.customer.dto;

import com.example.DDDModularMonolith.Modular.Monolith.Example.Using.DDD.product.dto.ProductDto;

import java.time.LocalDateTime;
import java.util.List;

public record GetCustomerRequestDto(String name, List<ProductDto> products, LocalDateTime createDate, LocalDateTime updateDate) {
}
