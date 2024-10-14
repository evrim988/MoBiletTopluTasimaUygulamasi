package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.exceptions.BakiyeYetersizException;
import com.eergun.mobilet.utility.enums.CardType;
import com.eergun.mobilet.utility.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data

public class CardSubscription extends Card{

    Integer remainingTap;
    @Builder.Default()
    Long expirationDate = Instant.now().plus(1, ChronoUnit.MONTHS).toEpochMilli();
    private CardType cardType;

    @Override
    public void tapTheCard(VehicleType vehicleType,Boolean isTransfer) {

//        if(this.getExpirationDate()< System.currentTimeMillis()){
//            this.setCardType(CardType.DEFAULT);
//        }


       int newRemainingTap;
        if(isTransfer){
            newRemainingTap = this.getRemainingTap()-1;
        }
        else{
            newRemainingTap = this.getRemainingTap()-vehicleType.getTapCount();
        }

        if(newRemainingTap < 0){
            throw new BakiyeYetersizException();
        }
        this.setRemainingTap(newRemainingTap);

    }

    @Override
    public String getRemainingUsageMessage() {
        return "Remaining Tap: " + remainingTap + " taps";
    }
}