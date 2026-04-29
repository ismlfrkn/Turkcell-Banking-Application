package com.turkcell.libraryapplication.exception;

public class UserAlreadyExistsException extends BusinessException {
     public UserAlreadyExistsException() {
        super("Kayıt işlemi verilen bilgiler ile tamamlanamadı. Lütfen bilgilerinizi kontrol ederek tekrar deneyiniz.");
    }
}
