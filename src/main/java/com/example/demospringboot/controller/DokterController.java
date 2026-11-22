package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.service.DokterService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DokterController {

    @Autowired
    private DokterService dokterService;

    // ================== HALAMAN DOKTER ==================
    @GetMapping({"/dokter", "/dokter/"})
    public String dokterPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
        List<Dokter> dokterList = dokterService.getAllDokter();
        model.addAttribute("dokterList", dokterList);
        model.addAttribute("dokterRec", new Dokter()); // form kosong
        return "dokter.html";
        } else {
            return "redirect:/login";
        }
    }

    // Saat user klik data untuk edit
    @GetMapping("/dokter/{id}")
    public String dokterGetRec(Model model, @PathVariable("id") Long id) {
        List<Dokter> dokterList = dokterService.getAllDokter();
        Dokter dokterRec = dokterService.getDokterById(id);
        model.addAttribute("dokterList", dokterList);
        model.addAttribute("dokterRec", dokterRec);
        return "dokter.html";
    }

    // Tombol ADD
    @PostMapping(value = {"/dokter/submit", "/dokter/submit/"}, params = {"add"})
    public String dokterAdd(@ModelAttribute("dokterRec") Dokter dokterRec) {
        dokterService.addDokter(dokterRec);
        return "redirect:/dokter";
    }

    // Tombol EDIT
    @PostMapping(value = "/dokter/submit/{id}", params = {"edit"})
    public String dokterEdit(@ModelAttribute("dokterRec") Dokter dokterRec, @PathVariable("id") Long id) {
        dokterService.updateDokter(id, dokterRec);
        return "redirect:/dokter";
    }

    // Tombol DELETE
    @PostMapping(value = "/dokter/submit/{id}", params = {"delete"})
    public String dokterDelete(@PathVariable("id") Long id) {
        dokterService.deleteDokter(id);
        return "redirect:/dokter";
    }
}
