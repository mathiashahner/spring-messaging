package com.mathiashahner.productmicroservice.domain.service;

import com.mathiashahner.productmicroservice.domain.Product;
import com.mathiashahner.productmicroservice.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found!"));
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public int getQuantityById(Long id) {
    return getProductById(id).quantity();
  }
}
