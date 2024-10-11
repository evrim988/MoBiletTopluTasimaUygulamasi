package com.eergun.mobilet.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found!!!!!!");
    }
}