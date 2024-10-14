package com.eergun.mobilet.entity.card;


import com.eergun.mobilet.exception.BakiyeYetersizException;
import com.eergun.mobilet.exception.ErrorType;
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
	public void tapTheCard(VehicleType vehicleType,Boolean isTransfer){
		double newBalance;
		if(isTransfer){
			newBalance = this.getBalance()-vehicleType.getPrice()*CardType.DEFAULT.getDiscountRate()*CardType.DEFAULT.getTransferDiscountedAmount();
		}
		else{
			newBalance = this.getBalance()-vehicleType.getPrice() * CardType.DEFAULT.getDiscountRate();
		}

		if(newBalance < 0){
			throw new BakiyeYetersizException(ErrorType.BAKIYE_YETERSIZ);
		}
		this.setBalance(newBalance);
	}
	
	public void makeDeposit(double amount) {
		balance += amount;
	}
	
}