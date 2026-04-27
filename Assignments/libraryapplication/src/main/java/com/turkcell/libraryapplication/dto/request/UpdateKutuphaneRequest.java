package com.turkcell.libraryapplication.dto.request;

import java.time.LocalTime;

public class UpdateKutuphaneRequest {

    private String kutuphaneAd;
    private String telefonNo;
    private LocalTime acilisSaati;
    private LocalTime kapanisSaati;
    private int ilKodu;

    public String getKutuphaneAd() { return kutuphaneAd; }
    public void setKutuphaneAd(String kutuphaneAd) { this.kutuphaneAd = kutuphaneAd; }
    public String getTelefonNo() { return telefonNo; }
    public void setTelefonNo(String telefonNo) { this.telefonNo = telefonNo; }
    public LocalTime getAcilisSaati() { return acilisSaati; }
    public void setAcilisSaati(LocalTime acilisSaati) { this.acilisSaati = acilisSaati; }
    public LocalTime getKapanisSaati() { return kapanisSaati; }
    public void setKapanisSaati(LocalTime kapanisSaati) { this.kapanisSaati = kapanisSaati; }
    public int getIlKodu() { return ilKodu; }
    public void setIlKodu(int ilKodu) { this.ilKodu = ilKodu; }
}
