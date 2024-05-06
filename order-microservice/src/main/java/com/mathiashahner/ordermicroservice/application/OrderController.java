package com.mathiashahner.ordermicroservice.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathiashahner.ordermicroservice.application.request.CreateOrderRequest;
import com.mathiashahner.ordermicroservice.application.response.OrderResponse;
import com.mathiashahner.ordermicroservice.domain.Order;
import com.mathiashahner.ordermicroservice.domain.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
    Order order = orderService.getOrderById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(OrderResponse.toResponse(order));
  }

  @PostMapping
  public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
    Order order = orderService.createOrder(CreateOrderRequest.toEntity(request));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(OrderResponse.toResponse(order));
  }
}
