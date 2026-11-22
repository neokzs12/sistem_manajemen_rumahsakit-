package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Ruangan;
import com.example.demospringboot.service.RuanganService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RuanganController {

    @Autowired
    private RuanganService ruanganService;

    // ================== HALAMAN RUANGAN ==================
    @GetMapping({"/ruangan", "/ruangan/"})
    public String ruanganPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
        List<Ruangan> ruanganList = ruanganService.getAllRuangan();
        model.addAttribute("ruanganList", ruanganList);
        model.addAttribute("ruanganRec", new Ruangan()); // form kosong
        return "ruangan.html";
        } else {
            return "redirect:/login";
        }
    }

    // Saat user klik record untuk edit
    @GetMapping("/ruangan/{id}")
    public String ruanganGetRec(Model model, @PathVariable("id") Long id) {
        List<Ruangan> ruanganList = ruanganService.getAllRuangan();
        Ruangan ruanganRec = ruanganService.getRuanganById(id);
        model.addAttribute("ruanganList", ruanganList);
        model.addAttribute("ruanganRec", ruanganRec);
        return "ruangan.html";
    }

    // ADD
    @PostMapping(value = {"/ruangan/submit", "/ruangan/submit/"}, params = {"add"})
    public String ruanganAdd(@ModelAttribute("ruanganRec") Ruangan ruanganRec) {
        ruanganService.addRuangan(ruanganRec);
        return "redirect:/ruangan";
    }

    // EDIT
    @PostMapping(value = "/ruangan/submit/{id}", params = {"edit"})
    public String ruanganEdit(@ModelAttribute("ruanganRec") Ruangan ruanganRec,
                              @PathVariable("id") Long id) {
        ruanganService.updateRuangan(id, ruanganRec);
        return "redirect:/ruangan";
    }

    // DELETE
    @PostMapping(value = "/ruangan/submit/{id}", params = {"delete"})
    public String ruanganDelete(@PathVariable("id") Long id) {
        ruanganService.deleteRuangan(id);
        return "redirect:/ruangan";
    }
}
