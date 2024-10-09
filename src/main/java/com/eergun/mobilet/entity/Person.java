package com.eergun.mobilet.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass

public abstract class Person extends BaseEntity{
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