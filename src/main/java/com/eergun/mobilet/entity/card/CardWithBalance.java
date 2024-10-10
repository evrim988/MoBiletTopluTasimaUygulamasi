package com.eergun.mobilet.entity.card;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="tblcardwithbalance")
@Entity
public abstract class CardWithBalance extends Card{
	double balance;
	
	@Override
	public String getRemainingUsageMessage() {
		return "Kalan bakiye: " + balance + "₺";
	}
}