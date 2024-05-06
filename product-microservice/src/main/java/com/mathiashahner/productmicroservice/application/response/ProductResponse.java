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
        product.id(),
        product.name(),
        product.description(),
        product.price(),
        product.quantity());
  }
}
