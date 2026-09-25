package com.siparis.model;

import java.util.ArrayList;
import java.util.List;

public class Siparis {
    private Musteri musteri;
    private List<Urun> urunler;

    public Siparis(Musteri musteri) {
        this.musteri = musteri;
        this.urunler = new ArrayList<>();
    }

    public void urunEkle(Urun urun) {
        urunler.add(urun);
    }

    public double toplamTutar() {
        double toplam = 0;
        for (Urun urun : urunler) {
            toplam += urun.getFiyat();
        }
        return toplam;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public List<Urun> getUrunler() {
        return urunler;
    }
}