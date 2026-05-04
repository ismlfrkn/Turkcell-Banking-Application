package com.turkcell.libraryapp.dto.kutuphaneogrenci.response;

import java.time.LocalDate;
import java.util.UUID;

public record GetByIdKutuphaneOgrenciResponse(
        UUID kutuphaneOgrenciId,
        UUID kutuphaneId,
        String kutuphaneAd,
        UUID ogrenciId,
        String ogrenciAd,
        String email,
        LocalDate kayitTarihi,
        String kartNo,
        boolean aktifMi
) {
}