package com.mathiashahner.ordermicroservice.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.mathiashahner.ordermicroservice.domain.repository.OrderRepository;
import com.mathiashahner.ordermicroservice.domain.repository.ProductMicroserviceRepository;
import com.mathiashahner.ordermicroservice.domain.service.OrderService;
import com.mathiashahner.ordermicroservice.domain.service.OrderServiceImpl;

@Configuration
public class BeanConfiguration {

  @Value("${api.product.base-url}")
  private String baseUrl;

  @Bean
  RestClient restClient() {
    return RestClient.create(baseUrl);
  }

  @Bean
  OrderService orderService(OrderRepository orderRepository,
      ProductMicroserviceRepository productRepository) {
    return new OrderServiceImpl(orderRepository, productRepository);
  }
}
