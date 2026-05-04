package com.turkcell.libraryapp.dto.yazar.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record YazarUpdateRequest(

        @NotBlank(message = "Yazar adı boş bırakılamaz.")
        String yazarAd,

        @NotBlank(message = "Ülke bilgisi boş bırakılamaz.")
        String ulke,

        @NotNull(message = "Yayınevi bilgisi zorunludur.")
        UUID yayineviId
) {
}