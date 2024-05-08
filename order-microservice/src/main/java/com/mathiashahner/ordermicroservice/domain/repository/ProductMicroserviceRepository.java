package com.mathiashahner.ordermicroservice.domain.repository;

public interface ProductMicroserviceRepository {

  int getQuantityById(Long id);

  void updateQuantityById(Long productId, int quantity);
}
