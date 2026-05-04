package com.turkcell.libraryapp_cqrs.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "personeller")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personel {

    @Id
    @UuidGenerator
    @Column(name = "personel_no", nullable = false, updatable = false)
    private UUID personelNo;

    @Column(name = "personel_ad", nullable = false, length = 100)
    private String personelAd;

    @Column(name = "gorev_baslangic", nullable = false)
    private LocalDate gorevBaslangic;

    @ManyToOne
    @JoinColumn(name = "kutuphane_id", nullable = false)
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

    public Kutuphane getKutuphane() {
        return kutuphane;
    }

    public void setKutuphane(Kutuphane kutuphane) {
        this.kutuphane = kutuphane;
    }

    

    
}