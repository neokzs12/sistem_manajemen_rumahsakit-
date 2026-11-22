package com.example.demospringboot.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

@Entity
public class Pasien extends Orang implements Login {

    @Size(min = 8)
    private String password;

    private String penyakit;

    public Pasien() {}

    public Pasien(String nama, String penyakit, String password) {
        super(nama);
        this.penyakit = penyakit;
        this.password = password;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    @Override
    public void signIn() {
        System.out.println("Pasien " + nama + " berhasil login.");
    }

    @Override
    public void signOut() {
        System.out.println("Pasien " + nama + " berhasil logout.");
    }
}
