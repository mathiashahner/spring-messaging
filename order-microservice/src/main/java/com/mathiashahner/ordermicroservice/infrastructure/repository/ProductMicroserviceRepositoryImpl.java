package com.mathiashahner.ordermicroservice.infrastructure.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mathiashahner.ordermicroservice.domain.repository.ProductMicroserviceRepository;
import com.mathiashahner.ordermicroservice.infrastructure.UpdateProductMessage;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMicroserviceRepositoryImpl implements ProductMicroserviceRepository {

  @Value("${api.product.get-quantity-uri}")
  private String getQuantityUri;

  @Value("${api.kafka.update-product-quantity}")
  private String updateProductQuantityTopic;

  private final RestClient restClient;
  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public int getQuantityById(Long id) {
    return restClient.get()
        .uri(getQuantityUri, id)
        .retrieve()
        .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
          throw new ResponseStatusException(response.getStatusCode(), response.getStatusText());
        })
        .body(Integer.class);
  }

  @Override
  public void updateQuantityById(Long productId, int quantity) {
    try {
      String message = objectMapper.writeValueAsString(new UpdateProductMessage(productId, quantity));
      kafkaTemplate.send(updateProductQuantityTopic, message);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
