package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    private Pasien pasien;

    @ManyToOne

    private Dokter dokter;

    @ManyToOne

    private Perawat perawat;

    @ManyToOne

    private Ruangan ruangan;

    @ManyToOne

    private Obat obat;

    @Embedded
    private JumlahHarga jumlahHarga;

    private double total;

    public Transaksi() {}

    public Transaksi(Pasien pasien, Dokter dokter, Perawat perawat,
                     Ruangan ruangan, Obat obat, JumlahHarga jumlahHarga) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.perawat = perawat;
        this.ruangan = ruangan;
        this.obat = obat;
        this.jumlahHarga = jumlahHarga;
    }

    //  KALKULATOR
    @PrePersist
    @PreUpdate
    public void hitungTotal() {
        if (obat != null && jumlahHarga != null) {
            this.total = obat.getHarga() * jumlahHarga.getJumlah();
        }
    }

    public Long getId() {
        return id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Perawat getPerawat() {
        return perawat;
    }

    public void setPerawat(Perawat perawat) {
        this.perawat = perawat;
    }

    public Ruangan getRuangan() {
        return ruangan;
    }

    public void setRuangan(Ruangan ruangan) {
        this.ruangan = ruangan;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public JumlahHarga getJumlahHarga() {
        return jumlahHarga;
    }

    public void setJumlahHarga(JumlahHarga jumlahHarga) {
        this.jumlahHarga = jumlahHarga;
    }

    public double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
