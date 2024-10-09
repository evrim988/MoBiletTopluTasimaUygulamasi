package com.eergun.mobilet.view;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VwCardUser {
	String name;
	String lastName;
	String phone;
	String adress;
}