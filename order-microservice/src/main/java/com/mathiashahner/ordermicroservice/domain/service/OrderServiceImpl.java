package com.mathiashahner.ordermicroservice.domain.service;

import com.mathiashahner.ordermicroservice.domain.Order;
import com.mathiashahner.ordermicroservice.domain.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found!"));
  }

  @Override
  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }
}
