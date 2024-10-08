package com.eergun.mobilet.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass

public abstract class Person extends BaseEntity{
	String name;
	String lastName;
	LocalDate birthDate;
	String password;
	@NotEmpty
	String email;
	String phone;
	String identityNo;
	String adress; // TODO adress entity'si aç
}