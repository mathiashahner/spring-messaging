package com.mathiashahner.productmicroservice.infrastructure;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.mathiashahner.productmicroservice.domain.Product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table("PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

  @Id
  Long id;
  String name;
  String description;
  BigDecimal price;
  int quantity;

  public ProductEntity(Product product) {
    id = product.id();
    name = product.name();
    description = product.description();
    price = product.price();
    quantity = product.quantity();
  }

  public Product toProduct() {
    return new Product(id, name, description, price, quantity);
  }
}
