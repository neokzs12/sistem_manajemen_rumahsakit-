package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Perawat;
import com.example.demospringboot.service.PerawatService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PerawatController {

    @Autowired
    private PerawatService perawatService;

    // ================== HALAMAN PERAWAT ==================
    @GetMapping({"/perawat", "/perawat/"})
    public String perawatPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
        List<Perawat> perawatList = perawatService.getAllPerawat();
        model.addAttribute("perawatList", perawatList);
        model.addAttribute("perawatRec", new Perawat()); // form kosong
        return "perawat.html";
        } else {
            return "redirect:/login";
        }
    }

    //untuk edit
    @GetMapping("/perawat/{id}")
    public String perawatGetRec(Model model, @PathVariable("id") Long id) {
        List<Perawat> perawatList = perawatService.getAllPerawat();
        Perawat perawatRec = perawatService.getPerawatById(id);
        model.addAttribute("perawatList", perawatList);
        model.addAttribute("perawatRec", perawatRec);
        return "perawat.html";
    }

    // Tombol ADD
    @PostMapping(value = {"/perawat/submit", "/perawat/submit/"}, params = {"add"})
    public String perawatAdd(@ModelAttribute("perawatRec") Perawat perawatRec) {
        perawatService.addPerawat(perawatRec);
        return "redirect:/perawat";
    }

    // Tombol EDIT
    @PostMapping(value = "/perawat/submit/{id}", params = {"edit"})
    public String perawatEdit(@ModelAttribute("perawatRec") Perawat perawatRec,
                              @PathVariable("id") Long id) {
        perawatService.updatePerawat(id, perawatRec);
        return "redirect:/perawat";
    }

    // Tombol DELETE
    @PostMapping(value = "/perawat/submit/{id}", params = {"delete"})
    public String perawatDelete(@PathVariable("id") Long id) {
        perawatService.deletePerawat(id);
        return "redirect:/perawat";
    }
}
