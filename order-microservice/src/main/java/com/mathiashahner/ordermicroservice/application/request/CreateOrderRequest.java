package com.mathiashahner.ordermicroservice.application.request;

import java.time.LocalDateTime;

import com.mathiashahner.ordermicroservice.domain.Order;

public record CreateOrderRequest(
    Long productId,
    int quantity,
    LocalDateTime date) {

  public static Order toEntity(CreateOrderRequest request) {
    return new Order(
        null,
        request.productId(),
        request.quantity(),
        request.date());
  }
}
