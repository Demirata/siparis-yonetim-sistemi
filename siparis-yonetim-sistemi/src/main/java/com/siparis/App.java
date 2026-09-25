package com.siparis;

import com.siparis.model.Musteri;
import com.siparis.model.Urun;
import com.siparis.model.Siparis;

public class App {
    public static void main(String[] args) {
        Musteri musteri = new Musteri("Tevfik Can Demirata", "tevfikcan.demirata@gmail.com");
        Siparis siparis = new Siparis(musteri);

        siparis.urunEkle(new Urun("Klavye", 450));
        siparis.urunEkle(new Urun("Mouse", 150));

        System.out.println(musteri.getAd() + " icin toplam tutar: " + siparis.toplamTutar());
    }
}