package com.example.demospringboot.service;

import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatService {

    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> getAllObat() {
        return obatRepository.findAll();
    }

    public Obat addObat(Obat obat) {
        obat.setId(null);
        return obatRepository.save(obat);
    }

    public Obat getObatById(Long id) {
        return obatRepository.findById(id).orElse(null);
    }

    public Obat updateObat(Long id, Obat obat) {
        obat.setId(id);
        return obatRepository.save(obat);
    }

    public void deleteObat(Long id) {
        obatRepository.deleteById(id);
    }
}
