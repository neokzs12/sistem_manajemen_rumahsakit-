package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JumlahHarga {

    @Column(name = "jumlah_obat")
    private Integer jumlah;

    public JumlahHarga() {}

    public JumlahHarga(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    
}
