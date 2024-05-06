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
        order.getId(),
        order.getProductId(),
        order.getQuantity(),
        order.getDate());
  }
}
