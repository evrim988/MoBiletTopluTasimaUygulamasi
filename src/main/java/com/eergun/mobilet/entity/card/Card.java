package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.entity.BaseEntity;
import com.eergun.mobilet.utility.enums.CardType;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "tblcard")
public abstract class Card extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "")
	String serialNumber;
	@Enumerated(EnumType.STRING)
	@Builder.Default
	CardType cardType = CardType.DEFAULT;
	
	
	// public abstract void pay();
}