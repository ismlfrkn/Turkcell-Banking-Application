package com.turkcell.libraryapp.dto.kutuphanesorumlusu.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record KutuphaneSorumlusuCreateRequest(

        @NotBlank(message = "Personel adı boş bırakılamaz.")
        String personelAd,

        @NotNull(message = "Görev başlangıç tarihi boş bırakılamaz.")
        LocalDate gorevBaslangic,

        @NotNull(message = "Kütüphane bilgisi zorunludur.")
        UUID kutuphaneId,

        @Min(value = 0, message = "Sorumlu maaşı negatif olamaz.")
        double sorumluMaas,

        @NotBlank(message = "Uzmanlık alanı boş bırakılamaz.")
        String uzmanlikAlani,

        @NotBlank(message = "Sertifika türü boş bırakılamaz.")
        String sertifikaTuru,

        @NotBlank(message = "Sorumlu bölüm boş bırakılamaz.")
        String sorumluBolum
) {
}