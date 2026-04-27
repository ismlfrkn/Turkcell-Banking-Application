package com.turkcell.libraryapplication.dto.request;

public class UpdateYayineviRequest {

    private String yayineviAd;
    private String telefonNo;
    private int ilKodu;

    public String getYayineviAd() { return yayineviAd; }
    public void setYayineviAd(String yayineviAd) { this.yayineviAd = yayineviAd; }
    public String getTelefonNo() { return telefonNo; }
    public void setTelefonNo(String telefonNo) { this.telefonNo = telefonNo; }
    public int getIlKodu() { return ilKodu; }
    public void setIlKodu(int ilKodu) { this.ilKodu = ilKodu; }
}
