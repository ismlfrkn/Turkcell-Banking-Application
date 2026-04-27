package com.turkcell.libraryapplication.dto.response;

import java.util.UUID;

public class YazarResponse {

    private UUID yazarNo;
    private String yazarAd;
    private String ulke;
    private UUID yayineviNo;

    public YazarResponse() {}

    public UUID getYazarNo() { return yazarNo; }
    public void setYazarNo(UUID yazarNo) { this.yazarNo = yazarNo; }
    public String getYazarAd() { return yazarAd; }
    public void setYazarAd(String yazarAd) { this.yazarAd = yazarAd; }
    public String getUlke() { return ulke; }
    public void setUlke(String ulke) { this.ulke = ulke; }
    public UUID getYayineviNo() { return yayineviNo; }
    public void setYayineviNo(UUID yayineviNo) { this.yayineviNo = yayineviNo; }
}
