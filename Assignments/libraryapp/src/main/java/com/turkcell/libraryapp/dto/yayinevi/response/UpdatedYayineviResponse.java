package com.turkcell.libraryapp.dto.yayinevi.response;

import java.util.UUID;

public record UpdatedYayineviResponse(
        UUID yayineviNo,
        String yayineviAd,
        String telefonNo,
        int ilKodu
) {
}