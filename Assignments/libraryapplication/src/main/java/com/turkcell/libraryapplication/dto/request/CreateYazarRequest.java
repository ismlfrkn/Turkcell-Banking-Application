package com.turkcell.libraryapplication.dto.request;

import java.util.UUID;

public class CreateYazarRequest {

    private String yazarAd;
    private String ulke;
    private UUID yayineviNo;

    public String getYazarAd() { return yazarAd; }
    public void setYazarAd(String yazarAd) { this.yazarAd = yazarAd; }
    public String getUlke() { return ulke; }
    public void setUlke(String ulke) { this.ulke = ulke; }
    public UUID getYayineviNo() { return yayineviNo; }
    public void setYayineviNo(UUID yayineviNo) { this.yayineviNo = yayineviNo; }
}
