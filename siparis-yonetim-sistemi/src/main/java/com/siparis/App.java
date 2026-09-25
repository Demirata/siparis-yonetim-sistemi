package com.siparis;

import com.siparis.model.Musteri;
import com.siparis.model.Urun;
import com.siparis.model.Siparis;
import com.siparis.service.SiparisHesaplayici;
import com.siparis.service.OdemeServisi;
import com.siparis.service.OdemeYontemi;
import com.siparis.service.KrediKartiOdeme;
import com.siparis.service.BankaKartiOdeme;
import com.siparis.service.TaksitliOdemeYapilabilir;

public class App {
    public static void main(String[] args) {
        Musteri musteri = new Musteri("Ahmet Yilmaz", "ahmet@example.com");
        Siparis siparis = new Siparis(musteri);

        siparis.urunEkle(new Urun("Klavye", 450.0));
        siparis.urunEkle(new Urun("Mouse", 150.0));

        SiparisHesaplayici hesaplayici = new SiparisHesaplayici();
        double toplam = hesaplayici.toplamTutar(siparis);
        System.out.println(musteri.getAd() + " icin toplam tutar: " + toplam);

        OdemeServisi odemeServisi = new OdemeServisi();
        OdemeYontemi krediKarti = new KrediKartiOdeme();
        OdemeYontemi bankaKarti = new BankaKartiOdeme();

        odemeServisi.odemeIsle(krediKarti, toplam);
        odemeServisi.odemeIsle(bankaKarti, toplam);

        // Taksit ozelligi: sadece destekleyenler icin guvenle calisir
        if (krediKarti instanceof TaksitliOdemeYapilabilir) {
            TaksitliOdemeYapilabilir taksitli = (TaksitliOdemeYapilabilir) krediKarti;
            taksitli.taksitYap(3, toplam);
        }

        if (bankaKarti instanceof TaksitliOdemeYapilabilir) {
            System.out.println("Banka karti taksit destekliyor (buraya hic girmeyecek).");
        } else {
            System.out.println("Banka karti taksit desteklemiyor - kod bunu zaten biliyor, hata firlatmadan atliyor.");
        }
    }
}