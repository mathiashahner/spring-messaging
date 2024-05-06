package com.mathiashahner.productmicroservice.application.response;

import java.math.BigDecimal;

import com.mathiashahner.productmicroservice.domain.Product;

public record ProductResponse(
    Long id,
    String name,
    String description,
    BigDecimal price,
    int quantity) {

  public static ProductResponse toResponse(Product product) {
    return new ProductResponse(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getQuantity());
  }
}
