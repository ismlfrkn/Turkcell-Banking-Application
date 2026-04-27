package com.turkcell.libraryapplication.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public class PersonelResponse {

    private UUID personelNo;
    private String personelAd;
    private LocalDate gorevBaslangic;
    private double maas;
    private UUID kutuphaneId;

    public PersonelResponse() {}

    public UUID getPersonelNo() { return personelNo; }
    public void setPersonelNo(UUID personelNo) { this.personelNo = personelNo; }
    public String getPersonelAd() { return personelAd; }
    public void setPersonelAd(String personelAd) { this.personelAd = personelAd; }
    public LocalDate getGorevBaslangic() { return gorevBaslangic; }
    public void setGorevBaslangic(LocalDate gorevBaslangic) { this.gorevBaslangic = gorevBaslangic; }
    public double getMaas() { return maas; }
    public void setMaas(double maas) { this.maas = maas; }
    public UUID getKutuphaneId() { return kutuphaneId; }
    public void setKutuphaneId(UUID kutuphaneId) { this.kutuphaneId = kutuphaneId; }
}
