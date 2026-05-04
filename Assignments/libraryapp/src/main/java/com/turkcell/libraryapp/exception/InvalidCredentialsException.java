package com.turkcell.libraryapp.exception;

public class InvalidCredentialsException extends BusinessException {

    public InvalidCredentialsException() {
        super("Email veya şifre hatalı.");
    }
}