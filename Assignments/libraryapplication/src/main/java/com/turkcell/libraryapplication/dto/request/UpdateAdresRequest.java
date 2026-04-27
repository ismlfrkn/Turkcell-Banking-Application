package com.turkcell.libraryapplication.dto.request;

public class UpdateAdresRequest {

    private String ilAdi;
    private String ilceAd;
    private String bolge;

    public String getIlAdi() { return ilAdi; }
    public void setIlAdi(String ilAdi) { this.ilAdi = ilAdi; }
    public String getIlceAd() { return ilceAd; }
    public void setIlceAd(String ilceAd) { this.ilceAd = ilceAd; }
    public String getBolge() { return bolge; }
    public void setBolge(String bolge) { this.bolge = bolge; }
}