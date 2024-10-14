package com.eergun.mobilet.entity.card;


import com.eergun.mobilet.exception.BakiyeYetersizException;
import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.utility.enums.CardType;
import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcardwithdiscount")
@DiscriminatorValue("card_with_discount")
public class CardWithDiscount extends CardWithBalance {

	Long cardUserId;
	@Enumerated(EnumType.STRING)
	CardType cardType;
	
	@Override
	public void tapTheCard(VehicleType vehicleType,Boolean isTransfer){
		if(this.getExpirationDate()< System.currentTimeMillis()){
			this.setCardType(CardType.DEFAULT);
		}
		double newBalance;
		if(isTransfer){
			newBalance = this.getBalance()-vehicleType.getPrice()*this.getCardType().getDiscountRate()*this.getCardType().getTransferDiscountedAmount();
		}
		else{
			newBalance = this.getBalance()-vehicleType.getPrice() * this.getCardType().getDiscountRate();
		}

		if(newBalance < 0){
			throw new BakiyeYetersizException(ErrorType.BAKIYE_YETERSIZ);
		}
		this.setBalance(newBalance);
	}
	
}