package com.turkcell.libraryapp_cqrs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kutuphane_sorumlulari")
@PrimaryKeyJoinColumn(name = "personel_no")
public class KutuphaneSorumlusu extends Personel {

    @Column(name = "sorumlu_maas", nullable = false)
    private double sorumluMaas;

    @Column(name = "uzmanlik_alani", nullable = false, length = 100)
    private String uzmanlikAlani;

    @Column(name = "sertifika_turu", nullable = false, length = 100)
    private String sertifikaTuru;

    @Column(name = "sorumlu_bolum", nullable = false, length = 100)
    private String sorumluBolum;

    public double getSorumluMaas() {
        return sorumluMaas;
    }

    public void setSorumluMaas(double sorumluMaas) {
        this.sorumluMaas = sorumluMaas;
    }

    public String getUzmanlikAlani() {
        return uzmanlikAlani;
    }

    public void setUzmanlikAlani(String uzmanlikAlani) {
        this.uzmanlikAlani = uzmanlikAlani;
    }

    public String getSertifikaTuru() {
        return sertifikaTuru;
    }

    public void setSertifikaTuru(String sertifikaTuru) {
        this.sertifikaTuru = sertifikaTuru;
    }

    public String getSorumluBolum() {
        return sorumluBolum;
    }

    public void setSorumluBolum(String sorumluBolum) {
        this.sorumluBolum = sorumluBolum;
    }

    
}