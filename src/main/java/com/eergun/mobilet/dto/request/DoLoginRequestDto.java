package com.eergun.mobilet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record DoLoginRequestDto(
        @Email
        String email,

        @Pattern(message = "Lütfen şifre kurallarına uyunuz",
                regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$")
        String password
) {
}
