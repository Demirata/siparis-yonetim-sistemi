package com.siparis;

import com.siparis.model.Musteri;
import com.siparis.model.Urun;
import com.siparis.model.Siparis;
import com.siparis.service.SiparisHesaplayici;
import com.siparis.service.OdemeServisi;
import com.siparis.service.KrediKartiOdeme;
import com.siparis.service.BankaKartiOdeme;

public class App {
    public static void main(String[] args) {
        Musteri musteri = new Musteri("Ahmet Yilmaz", "ahmet@example.com");
        Siparis siparis = new Siparis(musteri);

        siparis.urunEkle(new Urun("Klavye", 450.0));
        siparis.urunEkle(new Urun("Mouse", 150.0));

        SiparisHesaplayici hesaplayici = new SiparisHesaplayici();
        double toplam = hesaplayici.toplamTutar(siparis);
        System.out.println(musteri.getAd() + " icin toplam tutar: " + toplam);

        // OCP/DIP denemesi: ayni OdemeServisi, farkli odeme yontemleriyle calisiyor
        OdemeServisi odemeServisi = new OdemeServisi();
        odemeServisi.odemeIsle(new KrediKartiOdeme(), toplam);
        odemeServisi.odemeIsle(new BankaKartiOdeme(), toplam);
    }
}