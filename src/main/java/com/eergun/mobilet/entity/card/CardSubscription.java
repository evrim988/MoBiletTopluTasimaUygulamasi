package com.eergun.mobilet.entity.card;

import com.eergun.mobilet.utility.enums.VehicleType;

public class CardSubscription extends Card{

    Integer remainingTap;

    @Override
    public void tapTheCard(VehicleType vehicleType) {

    }

    @Override
    public String getRemainingUsageMessage() {
        return "Remaining Tap: " + remainingTap + " taps";
    }
}