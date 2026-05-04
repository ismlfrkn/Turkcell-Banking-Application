package com.turkcell.libraryapp.dto.ogrenci.response;

import java.util.UUID;

public record CreatedOgrenciResponse(
        UUID ogrenciId,
        String ogrenciAd,
        String email
) {
}