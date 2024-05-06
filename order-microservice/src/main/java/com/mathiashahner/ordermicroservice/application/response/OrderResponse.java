package com.mathiashahner.ordermicroservice.application.response;

import java.time.LocalDateTime;

import com.mathiashahner.ordermicroservice.domain.Order;

public record OrderResponse(
    Long id,
    Long productId,
    int quantity,
    LocalDateTime date) {

  public static OrderResponse toResponse(Order order) {
    return new OrderResponse(
        order.id(),
        order.productId(),
        order.quantity(),
        order.date());
  }
}
