package com.turkcell.libraryapp_cqrs.application.features.adres.command.create;

public record CreatedAdresResponse(
        int ilKod,
        String ilAd,
        String ilceAd,
        String bolge
) {
}