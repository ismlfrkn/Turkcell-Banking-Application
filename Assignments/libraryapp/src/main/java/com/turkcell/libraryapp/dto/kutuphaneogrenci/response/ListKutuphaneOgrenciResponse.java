package com.turkcell.libraryapp.dto.kutuphaneogrenci.response;

import java.time.LocalDate;
import java.util.UUID;

public record ListKutuphaneOgrenciResponse(
        UUID kutuphaneOgrenciId,
        String kutuphaneAd,
        String ogrenciAd,
        String kartNo,
        LocalDate kayitTarihi,
        boolean aktifMi
) {
}