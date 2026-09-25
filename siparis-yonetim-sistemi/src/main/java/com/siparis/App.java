package com.siparis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siparis.model.Musteri;
import com.siparis.model.Urun;
import com.siparis.model.Siparis;
import com.siparis.service.SiparisHesaplayici;
import com.siparis.service.OdemeServisi;
import com.siparis.service.OdemeYontemi;
import com.siparis.service.KrediKartiOdeme;
import com.siparis.service.BankaKartiOdeme;
import com.siparis.service.TaksitliOdemeYapilabilir;

@SpringBootApplication
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

        if (krediKarti instanceof TaksitliOdemeYapilabilir) {
            TaksitliOdemeYapilabilir taksitli = (TaksitliOdemeYapilabilir) krediKarti;
            taksitli.taksitYap(3, toplam);
        }

        if (bankaKarti instanceof TaksitliOdemeYapilabilir) {
            System.out.println("Banka karti taksit destekliyor (buraya hic girmeyecek).");
        } else {
            System.out.println("Banka karti taksit desteklemiyor - kod bunu zaten biliyor, hata firlatmadan atliyor.");
        }
        // YENİ: indirim hesaplama denemesi (feature/indirim-hesaplama)
           double indirimli = hesaplayici.indirimliTutar(siparis, 10);
           System.out.println("Yuzde 10 indirimli tutar: " + indirimli);
           
        // YENİ EKLENEN KISIM: konsol demosu bittikten sonra web sunucusunu baslat
        SpringApplication.run(App.class, args);
    }
}