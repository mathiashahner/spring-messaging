package com.mathiashahner.ordermicroservice.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mathiashahner.ordermicroservice.domain.Order;
import com.mathiashahner.ordermicroservice.domain.repository.OrderRepository;
import com.mathiashahner.ordermicroservice.infrastructure.OrderEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

  private final OrderRepositorySpring orderRepositorySpring;

  @Override
  public Optional<Order> findById(Long id) {
    Optional<OrderEntity> orderEntity = orderRepositorySpring.findById(id);

    if (orderEntity.isPresent()) {
      return Optional.of(orderEntity.get().toOrder());
    }
    return Optional.empty();
  }

  @Override
  public Order save(Order order) {
    OrderEntity orderEntity = orderRepositorySpring.save(new OrderEntity(order));
    return orderEntity.toOrder();
  }
}
