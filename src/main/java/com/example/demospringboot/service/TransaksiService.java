package com.example.demospringboot.service;

import com.example.demospringboot.entity.Transaksi;
import com.example.demospringboot.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    public List<Transaksi> getAllTransaksi() {
        return transaksiRepository.findAll();
    }

    public Transaksi addTransaksi(Transaksi transaksi) {
        transaksi.setId(null); // supaya dianggap data baru
        return transaksiRepository.save(transaksi); // total dihitung otomatis
    }

    public Transaksi getTransaksiById(Long id) {
        return transaksiRepository.findById(id).orElse(null);
    }

    public Transaksi updateTransaksi(Long id, Transaksi transaksi) {
        transaksi.setId(id);
        return transaksiRepository.save(transaksi); // total dihitung otomatis
    }

    public void deleteTransaksi(Long id) {
        transaksiRepository.deleteById(id);
    }
}
