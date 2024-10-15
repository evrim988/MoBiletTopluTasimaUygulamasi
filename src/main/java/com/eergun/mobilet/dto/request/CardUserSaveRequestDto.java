package com.eergun.mobilet.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public record CardUserSaveRequestDto(
		@NotBlank
		String name,
		@NotBlank
		String lastName,
		LocalDate birthDate,
		@NotBlank
		@Pattern(message = "Lütfen şifre kurallarına uyunuz",
				regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$")
		String password,
		@NotBlank
		@Email
		@Column(unique = true)
		String email,
		String phone,
		@Column(unique = true)
		@Size(min = 11, max = 11)
		@Digits(integer = 11, fraction = 0)
		String identityNo,
		String adress) {
	// TODO adress entity'si aç
}