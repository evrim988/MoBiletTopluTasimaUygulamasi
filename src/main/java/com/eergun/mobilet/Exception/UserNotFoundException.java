package com.eergun.mobilet.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User not found!!!!!!");
    }
}
