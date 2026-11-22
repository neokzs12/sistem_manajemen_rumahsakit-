package com.example.demospringboot.service;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.repository.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasienService {

    @Autowired
    private PasienRepository pasienRepository;

    public List<Pasien> getAllPasien() {
        return pasienRepository.findAll();
    }

    public Pasien addPasien(Pasien pasien) {
        pasien.setId(null);
        return pasienRepository.save(pasien);
    }

    public Pasien getPasienById(Long id) {
        return pasienRepository.findById(id).orElse(null);
    }

    public Pasien updatePasien(Long id, Pasien pasien) {
        pasien.setId(id);
        return pasienRepository.save(pasien);
    }

    public void deletePasien(Long id) {
        pasienRepository.deleteById(id);
    }

   
    public Pasien login(Long id, String password) {
        Pasien pasien = pasienRepository.findById(id).orElse(null);

        if (pasien == null) return null;
        if (!pasien.getPassword().equals(password)) return null;

        return pasien;
    }


}
