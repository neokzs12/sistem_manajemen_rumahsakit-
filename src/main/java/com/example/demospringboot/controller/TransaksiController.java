package com.example.demospringboot.controller;

import com.example.demospringboot.entity.*;
import com.example.demospringboot.service.*;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DokterService dokterService;

    @Autowired
    private PerawatService perawatService;

    @Autowired
    private RuanganService ruanganService;

    @Autowired
    private ObatService obatService;

    // ================== HALAMAN TRANSAKSI ==================
    @GetMapping({"/transaksi", "/transaksi/"})
    public String transaksiPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        List<Pasien> pasienList = pasienService.getAllPasien();
        List<Dokter> dokterList = dokterService.getAllDokter();
        List<Perawat> perawatList = perawatService.getAllPerawat();
        List<Ruangan> ruanganList = ruanganService.getAllRuangan();
        List<Obat> obatList = obatService.getAllObat();

        model.addAttribute("transaksiList", transaksiList);

        // Objek transaksi kosong untuk form
        Transaksi transaksiRec = new Transaksi();
        transaksiRec.setJumlahHarga(new JumlahHarga());

        model.addAttribute("transaksiRec", transaksiRec);

        model.addAttribute("pasienList", pasienList);
        model.addAttribute("dokterList", dokterList);
        model.addAttribute("perawatList", perawatList);
        model.addAttribute("ruanganList", ruanganList);
        model.addAttribute("obatList", obatList);
        
        return "transaksi.html";
        } else {
            return "redirect:/login";
        }
    }

    // Saat user klik data untuk edit
    @GetMapping("/transaksi/{id}")
    public String transaksiGetRec(Model model, @PathVariable("id") Long id) {

        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        List<Pasien> pasienList = pasienService.getAllPasien();
        List<Dokter> dokterList = dokterService.getAllDokter();
        List<Perawat> perawatList = perawatService.getAllPerawat();
        List<Ruangan> ruanganList = ruanganService.getAllRuangan();
        List<Obat> obatList = obatService.getAllObat();

        Transaksi transaksiRec = transaksiService.getTransaksiById(id);

        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("transaksiRec", transaksiRec);

        model.addAttribute("pasienList", pasienList);
        model.addAttribute("dokterList", dokterList);
        model.addAttribute("perawatList", perawatList);
        model.addAttribute("ruanganList", ruanganList);
        model.addAttribute("obatList", obatList);

        return "transaksi.html";
    }

    // Tombol ADD
    @PostMapping(value = {"/transaksi/submit", "/transaksi/submit/"}, params = {"add"})
    public String transaksiAdd(@ModelAttribute("transaksiRec") Transaksi transaksiRec) {
        transaksiService.addTransaksi(transaksiRec);
        return "redirect:/transaksi";
    }

    // Tombol EDIT
    @PostMapping(value = "/transaksi/submit/{id}", params = {"edit"})
    public String transaksiEdit(@ModelAttribute("transaksiRec") Transaksi transaksiRec,
                                @PathVariable("id") Long id) {
        transaksiService.updateTransaksi(id, transaksiRec);
        return "redirect:/transaksi";
    }

    // Tombol DELETE
    @PostMapping(value = "/transaksi/submit/{id}", params = {"delete"})
    public String transaksiDelete(@PathVariable("id") Long id) {
        transaksiService.deleteTransaksi(id);
        return "redirect:/transaksi";
    }
}
