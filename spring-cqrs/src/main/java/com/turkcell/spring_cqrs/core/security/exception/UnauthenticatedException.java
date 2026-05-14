package com.turkcell.spring_cqrs.core.security.exception;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException() {
        super("Bu işlem için giriş yapmalısınız.");
    }
}
    