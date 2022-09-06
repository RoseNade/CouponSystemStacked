package com.example.jb.Project2Againwoohoo.exceptions;

public class CustomExceptions extends Exception{
    public CustomExceptions(ErrMsg message) {
        super(message.getMessage());
    }
}
