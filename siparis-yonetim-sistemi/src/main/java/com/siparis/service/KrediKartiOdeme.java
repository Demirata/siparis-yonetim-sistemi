package com.siparis.service;

public class KrediKartiOdeme implements OdemeYontemi {
    @Override
    public void odemeYap(double tutar) {
        System.out.println("Kredi karti ile " + tutar + " TL odendi.");
    }
}