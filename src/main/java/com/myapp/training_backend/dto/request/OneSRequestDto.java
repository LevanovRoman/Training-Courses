package com.myapp.training_backend.dto.request;

public record OneSRequestDto(
        String department,
        String author,
        String fileName,
        String fileData
) {
}
