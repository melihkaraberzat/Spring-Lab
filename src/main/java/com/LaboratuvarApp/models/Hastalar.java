package com.LaboratuvarApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
public class Hastalar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dosyaNo;

    private String hastaAdi;
    private String hastaSoyadi;
    private Long hastaTC;
    private String taniBasligi;
    private String taniDetaylari;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date raporTarih;

    public Hastalar(){

    }
    public Hastalar(Integer dosyaNo,String hastaAdi,String hastaSoyadi,Long hastaTC,String taniBasligi,
                    String taniDetaylari,Date raporTarih){

        this.dosyaNo = dosyaNo;
        this.hastaAdi = hastaAdi;
        this.hastaSoyadi = hastaSoyadi;
        this.hastaTC = hastaTC;
        this.taniBasligi = taniBasligi;
        this.taniDetaylari = taniDetaylari;
        this.raporTarih = raporTarih;
    }

    public Integer getDosyaNo() {
        return dosyaNo;
    }

    public void setDosyaNo(Integer dosyaNo) {
        this.dosyaNo = dosyaNo;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }

    public String getHastaSoyadi() {
        return hastaSoyadi;
    }

    public void setHastaSoyadi(String hastaSoyadi) {
        this.hastaSoyadi = hastaSoyadi;
    }

    public Long getHastaTC() {
        return hastaTC;
    }

    public void setHastaTC(Long hastaTC) {
        this.hastaTC = hastaTC;
    }

    public String getTaniBasligi() {
        return taniBasligi;
    }

    public void setTaniBasligi(String taniBasligi) {
        this.taniBasligi = taniBasligi;
    }

    public String getTaniDetaylari() {
        return taniDetaylari;
    }

    public void setTaniDetaylari(String taniDetaylari) {
        this.taniDetaylari = taniDetaylari;
    }

    public Date getRaporTarih() {
        return raporTarih;
    }

    public void setRaporTarih(Date raporTarih) {
        this.raporTarih = raporTarih;
    }

    @Override
    public String toString() {
        return "Hastalar{" +
                "dosyaNo=" + dosyaNo +
                ", hastaAdi='" + hastaAdi + '\'' +
                ", hastaSoyadi='" + hastaSoyadi + '\'' +
                ", hastaTC=" + hastaTC +
                ", taniBasligi='" + taniBasligi + '\'' +
                ", taniDetaylari='" + taniDetaylari + '\'' +
                ", raporTarih=" + raporTarih +
                '}';
    }
}

