package com.eergun.mobilet.Exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException() {
        super("Card not found: ");
    }
}
