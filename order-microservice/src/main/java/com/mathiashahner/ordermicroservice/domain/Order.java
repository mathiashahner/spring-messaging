package com.mathiashahner.ordermicroservice.domain;

import java.time.LocalDateTime;

public record Order(
    Long id,
    Long productId,
    int quantity,
    LocalDateTime date) {
}
