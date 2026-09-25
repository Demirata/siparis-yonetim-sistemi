package com.siparis.controller;

import java.util.List;

public record SiparisOlusturmaIstegi(String musteriAd, String musteriEmail, List<UrunIstegi> urunler) {}