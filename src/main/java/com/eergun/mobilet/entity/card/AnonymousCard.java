package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.Exception.BakiyeYetersizException;
import com.eergun.mobilet.utility.enums.CardType;
import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@DiscriminatorValue("anonymous_card")
@Table(name = "tblanonymouscard")
public class AnonymousCard extends CardWithBalance {


	@Transient
	String name;

	@Override
	public String toString() {
		return "AnonymousCard{" +
				"id=" + id +
				", balance=" + balance +
				", serialNumber='" + serialNumber + '\'' +
				'}';
	}


	@Override
	public void tapTheCard(VehicleType vehicleType) {
		if(this.getBalance()<vehicleType.getPrice()){
			throw new BakiyeYetersizException();
		}
		this.setBalance(this.getBalance()-vehicleType.getPrice()* CardType.DEFAULT.getDiscountRate());
	}

	@Override
	public Double getRemainingBalance() {
		return this.getBalance();
	}
}