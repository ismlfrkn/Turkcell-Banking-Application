package com.turkcell.libraryapp.dto.yayinevi.response;

import java.util.UUID;

public record ListYayineviResponse(
        UUID yayineviNo,
        String yayineviAd,
        String telefonNo,
        int ilKodu,
        String ilAd
) {
}