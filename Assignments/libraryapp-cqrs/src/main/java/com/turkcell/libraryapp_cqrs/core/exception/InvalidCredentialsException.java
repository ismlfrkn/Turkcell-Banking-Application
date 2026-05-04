package com.turkcell.libraryapp_cqrs.core.exception;

public class InvalidCredentialsException extends BusinessException {

    public InvalidCredentialsException() {
        super("Email veya şifre hatalı.");
    }
}