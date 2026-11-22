package com.example.demospringboot.service;

import com.example.demospringboot.entity.Ruangan;
import com.example.demospringboot.repository.RuanganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuanganService {

    @Autowired
    private RuanganRepository ruanganRepository;

    public List<Ruangan> getAllRuangan() {
        return ruanganRepository.findAll();
    }

    public Ruangan addRuangan(Ruangan ruangan) {
        ruangan.setId(null);
        return ruanganRepository.save(ruangan);
    }

    public Ruangan getRuanganById(Long id) {
        return ruanganRepository.findById(id).orElse(null);
    }

    public Ruangan updateRuangan( Long id, Ruangan ruangan) {
        ruangan.setId(id);
        return ruanganRepository.save(ruangan);
    }

    public void deleteRuangan(Long id) {
        ruanganRepository.deleteById(id);
    }
}
