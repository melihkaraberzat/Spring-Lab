package com.LaboratuvarApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laborantlar {
    public String laborantAd;
    public String laborantSoyad;
    @Id
    public Integer laborantId;


    public Laborantlar(){

    }

    public Laborantlar(String laborantAd, String laborantSoyad, Integer laborantId) {
        this.laborantAd = laborantAd;
        this.laborantSoyad = laborantSoyad;
        this.laborantId = laborantId;
    }

    public String getLaborantAd() {
        return laborantAd;
    }

    public void setLaborantAd(String laborantAd) {
        this.laborantAd = laborantAd;
    }

    public String getLaborantSoyad() {
        return laborantSoyad;
    }

    public void setLaborantSoyad(String laborantSoyad) {
        this.laborantSoyad = laborantSoyad;
    }

    public Integer getLaborantId() {
        return laborantId;
    }

    public void setLaborantId(Integer laborantId) {
        this.laborantId = laborantId;
    }
}
