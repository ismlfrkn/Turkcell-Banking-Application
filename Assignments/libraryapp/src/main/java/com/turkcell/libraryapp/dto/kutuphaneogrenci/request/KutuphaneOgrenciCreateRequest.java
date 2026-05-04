package com.turkcell.libraryapp.dto.kutuphaneogrenci.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record KutuphaneOgrenciCreateRequest(

        @NotNull(message = "Kütüphane bilgisi zorunludur.")
        UUID kutuphaneId,

        @NotNull(message = "Öğrenci bilgisi zorunludur.")
        UUID ogrenciId,

        @NotBlank(message = "Kart numarası boş bırakılamaz.")
        String kartNo
) {
}