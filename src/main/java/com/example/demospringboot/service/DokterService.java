package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.repository.DokterRepository;

import java.util.List;

@Service
public class DokterService {

    @Autowired
    private DokterRepository dokterRepository;

    public List<Dokter> getAllDokter() {
        return dokterRepository.findAll();
    }

    public Dokter addDokter(Dokter dokter) {
        dokter.setId(null);
        return dokterRepository.save(dokter);
    }

    public Dokter getDokterById(Long id) {
        return dokterRepository.findById(id).orElse(null);
    }

    public Dokter updateDokter(Long id, Dokter dokter) {
        dokter.setId(id);
        return dokterRepository.save(dokter);
    }

    public void deleteDokter(Long id) {
        dokterRepository.deleteById(id);
    }
}
