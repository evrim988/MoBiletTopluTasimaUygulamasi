package com.eergun.mobilet.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found!!!!!!");
    }
}