package com.mathiashahner.productmicroservice.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.mathiashahner.productmicroservice.infrastructure.ProductEntity;

public interface ProductRepositorySpring extends CrudRepository<ProductEntity, Long> {
}
