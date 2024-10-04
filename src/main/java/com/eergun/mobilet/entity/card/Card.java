package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.entity.BaseEntity;
import com.eergun.mobilet.utility.enums.CardType;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public abstract class Card extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String serialNumber;
	CardType cardType;
	
	// public abstract void pay();
}