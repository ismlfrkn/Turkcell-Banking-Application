package com.turkcell.libraryapp.dto.kutuphaneogrenci.request;

import jakarta.validation.constraints.NotBlank;

public record KutuphaneOgrenciUpdateRequest(

        @NotBlank(message = "Kart numarası boş bırakılamaz.")
        String kartNo,

        boolean aktifMi
) {
}