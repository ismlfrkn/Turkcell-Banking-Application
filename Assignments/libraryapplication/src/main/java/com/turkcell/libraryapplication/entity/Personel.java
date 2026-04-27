package com.turkcell.libraryapplication.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personel")
public class Personel {

    @Id
    @UuidGenerator()
    @Column(name = "personel_no")
    private UUID personelNo;

    @Column(name = "personel_ad", nullable = false, length = 150)
    private String personelAd;

    @Column(name = "gorev_baslangic")
    private LocalDate gorevBaslangic;

    @Column(name = "maas")
    private double maas;

    @ManyToOne
    @JoinColumn(name = "kutuphane_id")
    private Kutuphane kutuphane;

    public UUID getPersonelNo() {
        return personelNo;
    }

    public void setPersonelNo(UUID personelNo) {
        this.personelNo = personelNo;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }

    public LocalDate getGorevBaslangic() {
        return gorevBaslangic;
    }

    public void setGorevBaslangic(LocalDate gorevBaslangic) {
        this.gorevBaslangic = gorevBaslangic;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    
}