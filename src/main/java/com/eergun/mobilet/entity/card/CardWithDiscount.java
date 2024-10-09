package com.eergun.mobilet.entity.card;


import com.eergun.mobilet.exception.BakiyeYetersizException;
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
@Table(name = "tblcardwithdiscount")
@DiscriminatorValue("card_with_discount")
public class CardWithDiscount extends CardWithBalance {
	Double discount;
	Long cardUserId;
	@Enumerated(EnumType.STRING)
	CardType cardType;
	
	@Override
	public void tapTheCard(VehicleType vehicleType){
		double newBalance = this.getBalance()-vehicleType.getPrice() * this.getCardType().getDiscountRate();
		if(newBalance < 0){
			throw new BakiyeYetersizException();
		}
		this.setBalance(newBalance);
	}
	
}