package com.mathiashahner.productmicroservice.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private int quantity;
}
