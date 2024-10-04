package com.eergun.mobilet.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
	String email;
	String phone;
	String identityNo;
	String adress; // TODO adress entity'si aç
}