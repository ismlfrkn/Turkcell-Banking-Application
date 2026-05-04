package com.turkcell.libraryapp.dto.adres.response;

public record UpdatedAdresResponse(
        int ilKodu,
        String ilAd,
        String ilceAd,
        String bolge
) {
}