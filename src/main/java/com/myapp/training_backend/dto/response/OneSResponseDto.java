package com.myapp.training_backend.dto.response;

public record OneSResponseDto(
        String title,
        String author,
        String recipient,
        String fileName,
        String fileData,
        Boolean start
) {
}
