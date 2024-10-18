package com.eergun.mobilet.view;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VwCardUser {
	String name;
	String lastName;
	String phone;
	String email;
	String adress;
	LocalDate birthDate;

}