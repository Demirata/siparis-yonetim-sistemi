package com.siparis.service;

// ESKİ HALİ (ISP öncesi): sadece OdemeYontemi implement ediyordu, taksit yoktu
// public class KrediKartiOdeme implements OdemeYontemi {

// YENİ HALİ: TaksitliOdemeYapilabilir de eklendi
// Neden: ISP - taksit özelliği ayrı bir arayüze taşındı, sadece isteyen sınıflar (KrediKarti) implement ediyor
public class KrediKartiOdeme implements OdemeYontemi, TaksitliOdemeYapilabilir {

    @Override
    public void odemeYap(double tutar) {
        System.out.println("Kredi karti ile " + tutar + " TL odendi.");
    }

    // YENİ METOT (ISP sonrası eklendi): sadece TaksitliOdemeYapilabilir'i implement edenler bunu yazar
    @Override
    public void taksitYap(int taksitSayisi, double tutar) {
        double aylikTutar = tutar / taksitSayisi;
        System.out.println(taksitSayisi + " taksit ile odeme yapildi, aylik: " + aylikTutar + " TL");
    }
}