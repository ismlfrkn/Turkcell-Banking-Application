package com.turkcell.libraryapp.dto.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterRequest(

        @NotBlank(message = "Email boş olamaz.")
        @Email(message = "Geçerli bir email giriniz.")
        String email,

        @NotBlank(message = "Şifre boş olamaz.")
        @Length(min = 6, max = 100, message = "Şifre 6 ile 100 karakter arasında olmalıdır.")
        String password
) {
}