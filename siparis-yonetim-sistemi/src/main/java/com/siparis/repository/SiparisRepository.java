package com.siparis.repository;

import com.siparis.model.Siparis;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SiparisRepository {

    private final Map<Long, Siparis> depo = new ConcurrentHashMap<>();
    private final AtomicLong idSayaci = new AtomicLong(1);

    public Siparis kaydet(Siparis siparis) {
        if (siparis.getId() == null) {
            siparis.setId(idSayaci.getAndIncrement());
        }
        depo.put(siparis.getId(), siparis);
        return siparis;
    }

    public List<Siparis> tumunuGetir() {
        return new ArrayList<>(depo.values());
    }

    public Siparis idIleGetir(Long id) {
        return depo.get(id);
    }

    public void sil(Long id) {
        depo.remove(id);
    }
}