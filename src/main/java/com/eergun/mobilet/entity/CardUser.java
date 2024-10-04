package com.eergun.mobilet.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcarduser")
public class CardUser extends Person{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
}