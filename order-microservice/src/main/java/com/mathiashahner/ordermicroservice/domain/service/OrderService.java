package com.mathiashahner.ordermicroservice.domain.service;

import com.mathiashahner.ordermicroservice.domain.Order;

public interface OrderService {

  Order getOrderById(Long id);

  Order createOrder(Order order);
}
