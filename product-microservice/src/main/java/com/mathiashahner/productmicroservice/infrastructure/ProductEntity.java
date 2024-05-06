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
    id = product.getId();
    name = product.getDescription();
    description = product.getDescription();
    price = product.getPrice();
    quantity = product.getQuantity();
  }

  public Product toProduct() {
    return new Product(id, name, description, price, quantity);
  }
}
