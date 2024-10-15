package com.eergun.mobilet.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AddMoneyRequestDto(@Positive Double amount,
                                 @NotEmpty
                                 @Size(min = 36, max = 36)
                                 String serialNumber) {
}