package com.turkcell.libraryapplication.dto.request;

public class CreateAdresRequest {

    private int ilKodu;
    private String ilAdi;
    private String ilceAd;
    private String bolge;

    public int getIlKodu() { return ilKodu; }
    public void setIlKodu(int ilKodu) { this.ilKodu = ilKodu; }
    public String getIlAdi() { return ilAdi; }
    public void setIlAdi(String ilAdi) { this.ilAdi = ilAdi; }
    public String getIlceAd() { return ilceAd; }
    public void setIlceAd(String ilceAd) { this.ilceAd = ilceAd; }
    public String getBolge() { return bolge; }
    public void setBolge(String bolge) { this.bolge = bolge; }
}