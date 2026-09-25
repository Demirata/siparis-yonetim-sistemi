package com.siparis;

import com.siparis.model.Musteri;
import com.siparis.model.Urun;
import com.siparis.model.Siparis;
import com.siparis.service.SiparisHesaplayici;

public class App {
    public static void main(String[] args) {
        Musteri musteri = new Musteri("Ahmet Yilmaz", "ahmet@example.com");
        Siparis siparis = new Siparis(musteri);

        siparis.urunEkle(new Urun("Klavye", 450.0));
        siparis.urunEkle(new Urun("Mouse", 150.0));

        // ESKİ HALİ (SRP öncesi): siparis kendi toplamını kendi hesaplıyordu
        // System.out.println(musteri.getAd() + " icin toplam tutar: " + siparis.toplamTutar());

        // YENİ HALİ: hesaplama ayrı bir servise devredildi
        SiparisHesaplayici hesaplayici = new SiparisHesaplayici();
        double toplam = hesaplayici.toplamTutar(siparis);
        System.out.println(musteri.getAd() + " icin toplam tutar: " + toplam);
    }
}