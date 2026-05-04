package com.turkcell.libraryapp.dto.adres.response;

public record GetByIdAdresResponse(
        int ilKodu,
        String ilAd,
        String ilceAd,
        String bolge
) {
}