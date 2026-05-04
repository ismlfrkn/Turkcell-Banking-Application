package com.turkcell.libraryapp.dto.adres.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AdresCreateRequest(
        @Min(value = 1, message = "Türkiye için geçerli bir il numarası giriniz")
        @Max(value = 81, message = "Türkiye için geçerli bir il numarası giriniz")
        int ilKod,

        @NotBlank(message = "İl adı boş bırakılamaz.")
        String ilAd,

        @NotBlank(message = "İlçe adı boş bırakılamaz.")
        String ilceAd,

        @NotBlank(message = "Bölge boş bırakılamaz.")
        String bolge
) {}