package com.mathiashahner.ordermicroservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mathiashahner.ordermicroservice.domain.repository.OrderRepository;
import com.mathiashahner.ordermicroservice.domain.service.OrderService;
import com.mathiashahner.ordermicroservice.domain.service.OrderServiceImpl;

@Configuration
public class BeanConfiguration {

  @Bean
  OrderService orderService(OrderRepository orderRepository) {
    return new OrderServiceImpl(orderRepository);
  }
}
