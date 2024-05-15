package com.mathiashahner.productmicroservice.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathiashahner.productmicroservice.application.request.CreateProductRequest;
import com.mathiashahner.productmicroservice.application.request.UpdateProductMessage;
import com.mathiashahner.productmicroservice.application.response.ProductResponse;
import com.mathiashahner.productmicroservice.domain.Product;
import com.mathiashahner.productmicroservice.domain.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;
  private final ObjectMapper objectMapper;

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
    Product product = productService.getProductById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(ProductResponse.toResponse(product));
  }

  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
    Product product = productService.createProduct(CreateProductRequest.toEntity(request));
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ProductResponse.toResponse(product));
  }

  @GetMapping("/{id}/quantity")
  public ResponseEntity<Integer> getQuantityById(@PathVariable Long id) {
    int quantity = productService.getQuantityById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(Integer.valueOf(quantity));
  }

  @KafkaListener(topics = "${api.kafka.update-product-quantity}", groupId = "group-1")
  public void updateQuantityById(String message) throws JsonMappingException, JsonProcessingException {
    UpdateProductMessage updateProduct = objectMapper.readValue(message, UpdateProductMessage.class);
    productService.updateQuantityById(updateProduct.id(), updateProduct.quantity());
  }
}
