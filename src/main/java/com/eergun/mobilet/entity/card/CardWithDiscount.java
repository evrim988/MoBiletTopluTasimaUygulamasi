package com.eergun.mobilet.entity.card;


import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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


	@Override
	public void tapTheCard(VehicleType vehicleType) {

	}

	@Override
	public Double getRemainingBalance() {
		return this.getBalance();
	}
}