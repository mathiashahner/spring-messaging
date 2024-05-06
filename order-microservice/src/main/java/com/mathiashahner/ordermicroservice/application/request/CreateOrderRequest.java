package com.mathiashahner.ordermicroservice.application.request;

import com.mathiashahner.ordermicroservice.domain.Order;

import jakarta.validation.constraints.NotNull;

public record CreateOrderRequest(
    @NotNull Long productId,
    @NotNull int quantity) {

  public static Order toEntity(CreateOrderRequest request) {
    return new Order(
        null,
        request.productId(),
        request.quantity(),
        null);
  }
}
