package com.eergun.mobilet.exceptions;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException() {
        super("Card not found: ");
    }
}