package com.mathiashahner.productmicroservice.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mathiashahner.productmicroservice.domain.Product;
import com.mathiashahner.productmicroservice.domain.repository.ProductRepository;
import com.mathiashahner.productmicroservice.infrastructure.ProductEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

  private final ProductRepositorySpring productRepositorySpring;

  @Override
  public Optional<Product> findById(Long id) {
    Optional<ProductEntity> productEntity = productRepositorySpring.findById(id);

    if (productEntity.isPresent()) {
      return Optional.of(productEntity.get().toProduct());
    }
    return Optional.empty();
  }

  @Override
  public Product save(Product product) {
    ProductEntity productEntity = productRepositorySpring.save(new ProductEntity(product));
    return productEntity.toProduct();
  }
}
