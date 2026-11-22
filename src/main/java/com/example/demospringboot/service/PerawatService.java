package com.example.demospringboot.service;

import com.example.demospringboot.entity.Perawat;
import com.example.demospringboot.repository.PerawatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerawatService {

    @Autowired
    private PerawatRepository perawatRepository;

    public List<Perawat> getAllPerawat() {
        return perawatRepository.findAll();
    }

    public Perawat addPerawat(Perawat perawat) {
        perawat.setId(null);
        return perawatRepository.save(perawat);
    }

    public Perawat getPerawatById(Long id) {
        return perawatRepository.findById(id).orElse(null);
    }

    public Perawat updatePerawat(Long id, Perawat perawat) {
        perawat.setId(id);
        return perawatRepository.save(perawat);
    }

    public void deletePerawat(Long id) {
        perawatRepository.deleteById(id);
    }
}
