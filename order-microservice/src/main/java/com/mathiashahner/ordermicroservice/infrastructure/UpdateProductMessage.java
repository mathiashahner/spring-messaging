package com.mathiashahner.ordermicroservice.infrastructure;

public record UpdateProductMessage(
    Long id,
    int quantity) {
}
