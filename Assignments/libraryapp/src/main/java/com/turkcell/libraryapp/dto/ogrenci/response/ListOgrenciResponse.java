package com.turkcell.libraryapp.dto.ogrenci.response;

import java.util.UUID;

public record ListOgrenciResponse(
        UUID ogrenciId,
        String ogrenciAd,
        String email
) {
}