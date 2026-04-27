package com.turkcell.libraryapplication.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class CreateKutuphaneOgrenciRequest {

    private UUID ogrenciId;
    private UUID kutuphaneId;
    private LocalDate kayitTarihi;
    private String kartNo;
    private boolean aktifMi;

    public UUID getOgrenciId() { return ogrenciId; }
    public void setOgrenciId(UUID ogrenciId) { this.ogrenciId = ogrenciId; }
    public UUID getKutuphaneId() { return kutuphaneId; }
    public void setKutuphaneId(UUID kutuphaneId) { this.kutuphaneId = kutuphaneId; }
    public LocalDate getKayitTarihi() { return kayitTarihi; }
    public void setKayitTarihi(LocalDate kayitTarihi) { this.kayitTarihi = kayitTarihi; }
    public String getKartNo() { return kartNo; }
    public void setKartNo(String kartNo) { this.kartNo = kartNo; }
    public boolean isAktifMi() { return aktifMi; }
    public void setAktifMi(boolean aktifMi) { this.aktifMi = aktifMi; }
}
