package com.eergun.mobilet.entity.card;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

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

	public void makeDeposit(double amount) {
		balance += amount;
	}


}
