package com.siparis.controller;

import com.siparis.model.Musteri;
import com.siparis.model.Siparis;
import com.siparis.model.Urun;
import com.siparis.repository.SiparisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparisler")
public class SiparisController {

    private final SiparisRepository siparisRepository;

    public SiparisController(SiparisRepository siparisRepository) {
        this.siparisRepository = siparisRepository;
    }

    @GetMapping
    public List<Siparis> tumSiparisleriGetir() {
        return siparisRepository.tumunuGetir();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siparis> siparisGetir(@PathVariable Long id) {
        Siparis siparis = siparisRepository.idIleGetir(id);
        if (siparis == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(siparis);
    }

    @PostMapping
    public ResponseEntity<Siparis> siparisOlustur(@RequestBody SiparisOlusturmaIstegi istek) {
        Musteri musteri = new Musteri(istek.musteriAd(), istek.musteriEmail());
        Siparis siparis = new Siparis(musteri);
        for (UrunIstegi u : istek.urunler()) {
            siparis.urunEkle(new Urun(u.isim(), u.fiyat()));
        }
        Siparis kaydedilen = siparisRepository.kaydet(siparis);
        return ResponseEntity.status(HttpStatus.CREATED).body(kaydedilen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Siparis> siparisGuncelle(@PathVariable Long id, @RequestBody SiparisOlusturmaIstegi istek) {
        Siparis mevcut = siparisRepository.idIleGetir(id);
        if (mevcut == null) {
            return ResponseEntity.notFound().build();
        }
        Musteri musteri = new Musteri(istek.musteriAd(), istek.musteriEmail());
        Siparis guncellenmis = new Siparis(musteri);
        guncellenmis.setId(id);
        for (UrunIstegi u : istek.urunler()) {
            guncellenmis.urunEkle(new Urun(u.isim(), u.fiyat()));
        }
        siparisRepository.kaydet(guncellenmis);
        return ResponseEntity.ok(guncellenmis);
    }

    @PatchMapping("/{id}/urunler")
    public ResponseEntity<Siparis> sipariseUrunEkle(@PathVariable Long id, @RequestBody UrunIstegi istek) {
        Siparis siparis = siparisRepository.idIleGetir(id);
        if (siparis == null) {
            return ResponseEntity.notFound().build();
        }
        siparis.urunEkle(new Urun(istek.isim(), istek.fiyat()));
        return ResponseEntity.ok(siparis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> siparisSil(@PathVariable Long id) {
        Siparis siparis = siparisRepository.idIleGetir(id);
        if (siparis == null) {
            return ResponseEntity.notFound().build();
        }
        siparisRepository.sil(id);
        return ResponseEntity.noContent().build();
    }
}