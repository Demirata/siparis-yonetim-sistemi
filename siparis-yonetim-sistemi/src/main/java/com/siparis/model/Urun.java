package com.siparis.model;

public class Urun {
    private String isim;
    private double fiyat;

    public Urun(String isim, double fiyat) {
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public double getFiyat() {
        return fiyat;
    }
}