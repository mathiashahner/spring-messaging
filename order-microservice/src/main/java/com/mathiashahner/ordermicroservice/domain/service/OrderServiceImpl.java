package com.mathiashahner.ordermicroservice.domain.service;

import java.time.LocalDateTime;

import com.mathiashahner.ordermicroservice.domain.Order;
import com.mathiashahner.ordermicroservice.domain.repository.OrderRepository;
import com.mathiashahner.ordermicroservice.domain.repository.ProductMicroserviceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ProductMicroserviceRepository productMicroserviceRepository;

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found!"));
  }

  @Override
  public Order createOrder(Order order) {

    if (order.getQuantity() <= 0) {
      throw new RuntimeException("Order quantity must be greater than zero!");
    }

    Integer productQuantity = productMicroserviceRepository
        .getQuantityById(order.getProductId());

    if (productQuantity < order.getQuantity()) {
      throw new RuntimeException("Insufficient stock!");
    }

    order.setDate(LocalDateTime.now());
    return orderRepository.save(order);
  }
}
