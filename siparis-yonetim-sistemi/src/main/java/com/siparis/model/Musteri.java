package com.siparis.model;

public class Musteri {
    private String ad;
    private String email;

    public Musteri(String ad, String email) {
        this.ad = ad;
        this.email = email;
    }

    public String getAd() {
        return ad;
    }

    public String getEmail() {
        return email;
    }
}