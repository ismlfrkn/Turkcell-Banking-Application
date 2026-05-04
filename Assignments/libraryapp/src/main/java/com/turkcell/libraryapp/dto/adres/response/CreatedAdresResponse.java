package com.turkcell.libraryapp.dto.adres.response;

public record CreatedAdresResponse(
        int ilKodu,
        String ilAd,
        String ilceAd,
        String bolge
) {
}