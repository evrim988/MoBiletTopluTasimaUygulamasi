package com.eergun.mobilet.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException() {
        super("Card not found: ");
    }
}