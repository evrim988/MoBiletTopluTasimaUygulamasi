package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.exception.BakiyeYetersizException;
import com.eergun.mobilet.utility.enums.CardType;
import com.eergun.mobilet.utility.enums.VehicleType;
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
	
	@Override
	public String getRemainingUsageMessage() {
		return "Kalan bakiye: " + balance + "₺";
	}
}