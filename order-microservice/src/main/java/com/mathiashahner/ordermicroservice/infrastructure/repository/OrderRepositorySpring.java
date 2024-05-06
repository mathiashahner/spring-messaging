package com.mathiashahner.ordermicroservice.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.mathiashahner.ordermicroservice.infrastructure.OrderEntity;

public interface OrderRepositorySpring extends CrudRepository<OrderEntity, Long> {
}
