package com.turkcell.libraryapp.dto.ogrencikitap.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OgrenciKitapCreateRequest(

        @NotNull(message = "Öğrenci bilgisi zorunludur.")
        UUID ogrenciId,

        @NotNull(message = "Kütüphane kitap bilgisi zorunludur.")
        UUID kutuphaneKitapId
) {
}