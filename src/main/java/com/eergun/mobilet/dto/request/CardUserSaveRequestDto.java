package com.eergun.mobilet.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CardUserSaveRequestDto {
	@NotBlank
	String name;
	@NotBlank
	String lastName;
	LocalDate birthDate;
	@NotBlank
	@Pattern(message = "Lütfen şifre kurallarına uyunuz",
			regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$")
	String password;
	@NotBlank
	@Email
	@Column(unique = true)
	String email;
	String phone;
	@Column(unique = true)
	@Size(min = 11, max = 11)
	String identityNo;
	String adress; // TODO adress entity'si aç
}