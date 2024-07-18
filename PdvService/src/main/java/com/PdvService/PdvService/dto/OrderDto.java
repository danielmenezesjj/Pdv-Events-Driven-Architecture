package com.PdvService.PdvService.dto;

import com.PdvService.PdvService.model.Product;

public record OrderDto(
        String id,
        String typePayment,
        Integer quantity,
        String status,
        String productId // Note que aqui é uma String
) {
}

