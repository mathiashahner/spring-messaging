package com.mathiashahner.productmicroservice.domain.service;

import com.mathiashahner.productmicroservice.domain.Product;

public interface ProductService {

  Product getProductById(Long id);

  Product createProduct(Product product);

  int getQuantityById(Long id);
}
