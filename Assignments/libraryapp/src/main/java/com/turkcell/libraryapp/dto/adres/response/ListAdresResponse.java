package com.turkcell.libraryapp.dto.adres.response;

public record ListAdresResponse(
        int ilKodu,
        String ilAd,
        String ilceAd,
        String bolge
) {
}