package com.turkcell.libraryapplication.dto.response;

import java.util.UUID;

public class YayineviResponse {

    private UUID yayineviNo;
    private String yayineviAd;
    private String telefonNo;
    private int ilKodu;

    public YayineviResponse() {}

    public UUID getYayineviNo() { return yayineviNo; }
    public void setYayineviNo(UUID yayineviNo) { this.yayineviNo = yayineviNo; }
    public String getYayineviAd() { return yayineviAd; }
    public void setYayineviAd(String yayineviAd) { this.yayineviAd = yayineviAd; }
    public String getTelefonNo() { return telefonNo; }
    public void setTelefonNo(String telefonNo) { this.telefonNo = telefonNo; }
    public int getIlKodu() { return ilKodu; }
    public void setIlKodu(int ilKodu) { this.ilKodu = ilKodu; }
}
