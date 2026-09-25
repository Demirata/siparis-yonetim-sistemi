package com.siparis.service;

public class BankaKartiOdeme implements OdemeYontemi {
    @Override
    public void odemeYap(double tutar) {
        System.out.println("Banka karti ile " + tutar + " TL odendi.");
    }
}