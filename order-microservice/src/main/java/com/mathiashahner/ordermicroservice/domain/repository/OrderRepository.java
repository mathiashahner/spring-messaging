package com.mathiashahner.ordermicroservice.domain.repository;

import java.util.Optional;

import com.mathiashahner.ordermicroservice.domain.Order;

public interface OrderRepository {

  Optional<Order> findById(Long id);

  Order save(Order order);
}
