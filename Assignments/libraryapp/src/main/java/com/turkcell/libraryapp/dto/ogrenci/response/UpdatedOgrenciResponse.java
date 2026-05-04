package com.turkcell.libraryapp.dto.ogrenci.response;

import java.util.UUID;

public record UpdatedOgrenciResponse(
        UUID ogrenciId,
        String ogrenciAd,
        String email
) {
}