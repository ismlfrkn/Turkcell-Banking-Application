package com.turkcell.libraryapplication.dto.request;

import java.util.UUID;

public class CreateKitapRequest {

    private String kitapAd;
    private int sayfaSayisi;
    private String kitapTuru;
    private UUID yayineviNo;
    private UUID yazarNo;

    public String getKitapAd() { return kitapAd; }
    public void setKitapAd(String kitapAd) { this.kitapAd = kitapAd; }
    public int getSayfaSayisi() { return sayfaSayisi; }
    public void setSayfaSayisi(int sayfaSayisi) { this.sayfaSayisi = sayfaSayisi; }
    public String getKitapTuru() { return kitapTuru; }
    public void setKitapTuru(String kitapTuru) { this.kitapTuru = kitapTuru; }
    public UUID getYayineviNo() { return yayineviNo; }
    public void setYayineviNo(UUID yayineviNo) { this.yayineviNo = yayineviNo; }
    public UUID getYazarNo() { return yazarNo; }
    public void setYazarNo(UUID yazarNo) { this.yazarNo = yazarNo; }
}
