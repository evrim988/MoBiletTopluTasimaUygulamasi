package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.utility.enums.VehicleType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.query.sqm.TemporalUnit;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data

public class CardSubscription extends Card{

    Integer remainingTap;
    @Builder.Default()
    Long expirationDate = Instant.now().plus(1, ChronoUnit.MONTHS).toEpochMilli();

    @Override
    public void tapTheCard(VehicleType vehicleType,Boolean isTransfer) {

    }

    @Override
    public String getRemainingUsageMessage() {
        return "Remaining Tap: " + remainingTap + " taps";
    }
}