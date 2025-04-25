package com.myapp.training_backend.dto;

public record FileTestRequest(
        String fio,
        String filename,
        String filedata
) {
}
