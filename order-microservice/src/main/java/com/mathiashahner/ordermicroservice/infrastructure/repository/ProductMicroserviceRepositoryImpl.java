package com.mathiashahner.ordermicroservice.infrastructure.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import com.mathiashahner.ordermicroservice.domain.repository.ProductMicroserviceRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMicroserviceRepositoryImpl implements ProductMicroserviceRepository {

  @Value("${api.product.get-quantity-uri}")
  private String getQuantityUri;

  private final RestClient restClient;

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
}
