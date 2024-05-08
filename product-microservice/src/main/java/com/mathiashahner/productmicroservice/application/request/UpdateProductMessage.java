package com.mathiashahner.productmicroservice.application.request;

public record UpdateProductMessage(
    Long id,
    int quantity) {
}
