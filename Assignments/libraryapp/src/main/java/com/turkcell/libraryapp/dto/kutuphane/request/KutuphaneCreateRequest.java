package com.turkcell.libraryapp.dto.kutuphane.request;

import java.time.LocalTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record KutuphaneCreateRequest(

        @NotBlank(message = "Kütüphane adı boş olamaz")
        @Size(min = 2, max = 50, message = "Kütüphane adı 2 ile 50 karakter arasında olmalıdır")
        String kutuphaneAd,

        @NotBlank(message = "Telefon numarası boş olamaz")
        @Pattern(
                regexp = "^[0-9]{11}$",
                message = "Telefon numarası 11 haneli olmalıdır"
        )
        String telefonNo,

        @NotNull(message = "Açılış saati boş olamaz")
        LocalTime acilisSaati,

        @NotNull(message = "Kapanış saati boş olamaz")
        LocalTime kapanisSaati,

        @Min(value = 1, message = "Türkiye için geçerli bir il numarası giriniz")
        @Max(value = 81, message = "Türkiye için geçerli bir il numarası giriniz")
        int ilKodu
) {
}