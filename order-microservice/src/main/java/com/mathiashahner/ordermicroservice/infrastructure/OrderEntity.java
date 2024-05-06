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
  private Long id;
  private Long productId;
  private int quantity;
  private LocalDateTime date;

  public OrderEntity(Order order) {
    id = order.getId();
    productId = order.getProductId();
    quantity = order.getQuantity();
    date = order.getDate();
  }

  public Order toOrder() {
    return new Order(id, productId, quantity, date);
  }
}
