package com.eergun.mobilet.entity.card;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

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

	@Builder.Default
	Long expirationDate = ZonedDateTime.now().plus(1, ChronoUnit.YEARS).toInstant().toEpochMilli();
	
	@Override
	public String getRemainingUsageMessage() {
		return "Kalan bakiye: " + balance + "₺";
	}
}