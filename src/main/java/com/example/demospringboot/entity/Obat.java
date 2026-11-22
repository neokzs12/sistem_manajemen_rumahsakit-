package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class Obat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

 
    private String nama;


    private double harga;

    public Obat() {}

    public Obat(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
