package com.turkcell.libraryapp.dto.kutuphanekitap.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record KutuphaneKitapCreateRequest(

        @NotNull(message = "Kütüphane bilgisi zorunludur.")
        UUID kutuphaneId,

        @NotNull(message = "Kitap bilgisi zorunludur.")
        UUID kitapId,

        @Min(value = 0, message = "Stok miktarı negatif olamaz.")
        int stokMiktar
) {
}