package com.mathiashahner.productmicroservice.application.request;

import java.math.BigDecimal;

import com.mathiashahner.productmicroservice.domain.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
    @NotBlank String name,
    @NotBlank String description,
    @NotNull BigDecimal price,
    @NotNull int quantity) {

  public static Product toEntity(CreateProductRequest request) {
    return new Product(
        null,
        request.name(),
        request.description(),
        request.price(),
        request.quantity());
  }
}
