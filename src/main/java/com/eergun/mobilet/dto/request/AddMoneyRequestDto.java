package com.eergun.mobilet.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMoneyRequestDto {

    @Positive
    Double amount;

    @NotEmpty
    @Size(min = 36, max = 36)
    String serialNumber;
}
