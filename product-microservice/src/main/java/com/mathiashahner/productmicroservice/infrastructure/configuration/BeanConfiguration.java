package com.mathiashahner.productmicroservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mathiashahner.productmicroservice.domain.repository.ProductRepository;
import com.mathiashahner.productmicroservice.domain.service.ProductService;
import com.mathiashahner.productmicroservice.domain.service.ProductServiceImpl;

@Configuration
public class BeanConfiguration {

  @Bean
  ProductService productService(ProductRepository productRepository) {
    return new ProductServiceImpl(productRepository);
  }
}
