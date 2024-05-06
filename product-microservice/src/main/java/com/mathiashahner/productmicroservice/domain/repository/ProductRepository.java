package com.mathiashahner.productmicroservice.domain.repository;

import java.util.Optional;

import com.mathiashahner.productmicroservice.domain.Product;

public interface ProductRepository {

  Optional<Product> findById(Long id);

  Product save(Product product);

  void update(Product product);
}
