package com.siparis.service;

import com.siparis.model.Siparis;
import com.siparis.model.Urun;

public class SiparisHesaplayici {

    public double toplamTutar(Siparis siparis) {
        double toplam = 0;
        for (Urun urun : siparis.getUrunler()) {
            toplam += urun.getFiyat();
        }
        return toplam;
    }
}