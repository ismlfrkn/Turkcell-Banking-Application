package com.turkcell.libraryapp.dto.mudur.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record MudurUpdateRequest(

        @NotBlank(message = "Personel adı boş bırakılamaz.")
        String personelAd,

        @NotNull(message = "Görev başlangıç tarihi boş bırakılamaz.")
        LocalDate gorevBaslangic,

        @NotNull(message = "Kütüphane bilgisi zorunludur.")
        UUID kutuphaneId,

        @Min(value = 0, message = "Müdür maaşı negatif olamaz.")
        double mudurMaas,

        @NotBlank(message = "Diploma alanı boş bırakılamaz.")
        String diplomaAlani
) {
}