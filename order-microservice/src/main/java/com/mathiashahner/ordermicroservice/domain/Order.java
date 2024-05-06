package com.mathiashahner.ordermicroservice.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
  private Long id;
  private Long productId;
  private int quantity;
  private LocalDateTime date;
}
