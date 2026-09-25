package com.siparis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerhabaController {

    @GetMapping("/merhaba")
    public String merhaba() {
        return "Merhaba, Siparis Yonetim Sistemi calisiyor!";
    }
}