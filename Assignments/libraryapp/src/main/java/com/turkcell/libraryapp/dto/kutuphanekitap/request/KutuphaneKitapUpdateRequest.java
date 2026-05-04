package com.turkcell.libraryapp.dto.kutuphanekitap.request;

import jakarta.validation.constraints.Min;

public record KutuphaneKitapUpdateRequest(

        @Min(value = 0, message = "Stok miktarı negatif olamaz.")
        int stokMiktar
) {
}