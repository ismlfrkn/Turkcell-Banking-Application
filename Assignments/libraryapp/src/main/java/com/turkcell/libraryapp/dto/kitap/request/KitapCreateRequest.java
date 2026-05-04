package com.turkcell.libraryapp.dto.kitap.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record KitapCreateRequest(

        @NotBlank(message = "Kitap adı boş bırakılamaz.")
        String kitapAd,

        @NotBlank(message = "Kitap türü boş bırakılamaz.")
        String kitapTur,

        @Min(value = 10, message = "Kitap en az 10 sayfa olmalıdır.")
        @Max(value = 5000, message = "Çok büyük bir kitap girdiniz.")
        int sayfaSayi,

        @NotNull(message = "Yayınevi bilgisi zorunludur.")
        UUID yayineviId,

        @NotNull(message = "Yazar bilgisi zorunludur.")
        UUID yazarId
) {
}