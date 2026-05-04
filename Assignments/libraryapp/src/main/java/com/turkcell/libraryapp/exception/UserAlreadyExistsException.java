package com.turkcell.libraryapp.exception;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException() {
        super("İşlem gerçekleştirilemedi.");
    }
}