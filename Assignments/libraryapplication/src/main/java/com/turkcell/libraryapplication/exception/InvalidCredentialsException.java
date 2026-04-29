package com.turkcell.libraryapplication.exception;

public class InvalidCredentialsException extends BusinessException {

    public InvalidCredentialsException() {
        super("Email veya parola hatalı.");
    }
}