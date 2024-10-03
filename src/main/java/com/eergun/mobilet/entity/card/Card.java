package com.eergun.mobilet.entity;

import com.eergun.mobilet.utility.enums.CardType;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcard")
public class Card extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String serialNumber;
	Integer balance;
	Long cardUserId;
	CardType cardType;
}