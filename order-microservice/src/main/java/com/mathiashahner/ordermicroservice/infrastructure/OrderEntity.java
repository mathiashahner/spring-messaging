package com.mathiashahner.ordermicroservice.infrastructure;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.mathiashahner.ordermicroservice.domain.Order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table("ORDERS")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

  @Id
  Long id;
  Long productId;
  int quantity;
  LocalDateTime date;

  public OrderEntity(Order order) {
    id = order.id();
    productId = order.productId();
    quantity = order.quantity();
    date = order.date();
  }

  public Order toOrder() {
    return new Order(id, productId, quantity, date);
  }
}
