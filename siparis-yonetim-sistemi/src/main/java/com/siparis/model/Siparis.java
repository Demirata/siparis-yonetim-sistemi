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

    // --- ESKİ HALİ (SRP öncesi): hesaplama burada, Siparis'in içindeydi ---
    // public double toplamTutar() {
    //     double toplam = 0;
    //     for (Urun urun : urunler) {
    //         toplam += urun.getFiyat();
    //     }
    //     return toplam;
    // }
    // --- YENİ HALİ: bu mantık artık ayrı bir sınıfta ---
    // Bkz: com.siparis.service.SiparisHesaplayici.toplamTutar(Siparis)
    // Neden taşındı: SRP (Tek Sorumluluk) - Siparis artık sadece veri tutuyor, hesaplama yapmıyor.

    public Musteri getMusteri() {
        return musteri;
    }

    public List<Urun> getUrunler() {
        return urunler;
    }
}