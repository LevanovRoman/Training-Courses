package com.myapp.training_backend.dto.request;

import java.math.BigDecimal;

public record TrainingResultRequestDto(
        BigDecimal cardId,
        BigDecimal actualDeptRootId,
        BigDecimal appointId
) {
}
