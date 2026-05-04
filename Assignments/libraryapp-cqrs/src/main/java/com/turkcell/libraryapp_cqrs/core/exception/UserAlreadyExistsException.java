package com.turkcell.libraryapp_cqrs.core.exception;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException() {
        super("İşlem gerçekleştirilemedi.");
    }
}