package com.turkcell.libraryapp.dto.adres.request;

import jakarta.validation.constraints.NotBlank;

public record AdresUpdateRequest(
        @NotBlank(message = "İl adı boş bırakılamaz.")
        String ilAd,

        @NotBlank(message = "İlçe adı boş bırakılamaz.")
        String ilceAd,

        @NotBlank(message = "Bölge boş bırakılamaz.")
        String bolge
) {}