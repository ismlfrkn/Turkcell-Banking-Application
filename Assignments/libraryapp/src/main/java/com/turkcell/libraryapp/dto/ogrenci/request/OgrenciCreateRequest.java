package com.turkcell.libraryapp.dto.ogrenci.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record OgrenciCreateRequest(

        @NotBlank(message = "Öğrenci adı boş bırakılamaz.")
        String ogrenciAd,

        @NotBlank(message = "Email boş bırakılamaz.")
        @Email(message = "Geçerli bir email giriniz.")
        String email
) {
}