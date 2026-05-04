package com.turkcell.libraryapp_cqrs.application.features.ogrenci.command.create;

import java.util.UUID;

public record CreatedOgrenciResponse(
        UUID ogrenciId,
        String ogrenciAd,
        String email
) {
}