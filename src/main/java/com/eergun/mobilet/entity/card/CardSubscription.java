package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.exception.ErrorType;
import com.eergun.mobilet.exception.BakiyeYetersizException;
import com.eergun.mobilet.utility.enums.CardType;
import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@DiscriminatorValue("cardsubscription")
@Entity
@Table(name = "tblcardsubscription")
public class CardSubscription extends Card{

    Integer remainingTap;
    @Builder.Default()
    Long expirationDate = ZonedDateTime.now().plus(1, ChronoUnit.YEARS).toInstant().toEpochMilli();
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
            throw new BakiyeYetersizException(ErrorType.BAKIYE_YETERSIZ);
        }
        this.setRemainingTap(newRemainingTap);

    }

    @Override
    public String getRemainingUsageMessage() {
        return "Remaining Tap: " + remainingTap + " taps";
    }
}