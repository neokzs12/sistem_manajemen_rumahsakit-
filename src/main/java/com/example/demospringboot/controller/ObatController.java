package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Obat;
import com.example.demospringboot.service.ObatService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ObatController {

    @Autowired
    private ObatService obatService;

    // ================== HALAMAN OBAT ==================
    @GetMapping({"/obat", "/obat/"})

    public String obatPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
        List<Obat> obatList = obatService.getAllObat();
        model.addAttribute("obatList", obatList);
        model.addAttribute("obatRec", new Obat()); // form kosong
        return "obat.html";
        } else {
            return "redirect:/login";
        }
    }

    // Saat user klik data untuk edit
    @GetMapping("/obat/{id}")
    public String obatGetRec(Model model, @PathVariable("id") Long id) {
        List<Obat> obatList = obatService.getAllObat();
        Obat obatRec = obatService.getObatById(id);
        model.addAttribute("obatList", obatList);
        model.addAttribute("obatRec", obatRec);
        return "obat.html";
    }

    // Tombol ADD
    @PostMapping(value = {"/obat/submit", "/obat/submit/"}, params = {"add"})
    public String obatAdd(@ModelAttribute("obatRec") Obat obatRec) {
        obatService.addObat(obatRec);
        return "redirect:/obat";
    }

    // Tombol EDIT
    @PostMapping(value = "/obat/submit/{id}", params = {"edit"})
    public String obatEdit(@ModelAttribute("obatRec") Obat obatRec, @PathVariable("id") Long id) {
        obatService.updateObat(id, obatRec);
        return "redirect:/obat";
    }

    // Tombol DELETE
    @PostMapping(value = "/obat/submit/{id}", params = {"delete"})
    public String obatDelete(@PathVariable("id") Long id) {
        obatService.deleteObat(id);
        return "redirect:/obat";
    }
}
