package com.turkcell.libraryapplication.dto.request;

import java.time.LocalDate;

public class UpdateKutuphaneOgrenciRequest {

    private LocalDate kayitTarihi;
    private String kartNo;
    private boolean aktifMi;

    public LocalDate getKayitTarihi() { return kayitTarihi; }
    public void setKayitTarihi(LocalDate kayitTarihi) { this.kayitTarihi = kayitTarihi; }
    public String getKartNo() { return kartNo; }
    public void setKartNo(String kartNo) { this.kartNo = kartNo; }
    public boolean isAktifMi() { return aktifMi; }
    public void setAktifMi(boolean aktifMi) { this.aktifMi = aktifMi; }
}
