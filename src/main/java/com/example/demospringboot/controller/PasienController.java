package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.service.PasienService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService;

    //LOGIN PAGE
    
    @GetMapping("/login")
    public String pasienLoginPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("Pasien") != null) {
            return "redirect:/pasien";
        }
        return "login.html";
    }

    
    //VALIDATE LOGIN 
 
        @PostMapping("/validatelogin")
        public String pasienLogin(Model model,
                                @RequestParam("id") Long id,
                                @RequestParam("password") String passUser,
                                HttpServletRequest request) {

            Pasien p = pasienService.login(id, passUser);

            if (p != null) {
                request.getSession().setAttribute("Pasien", p);
                return "redirect:/pasien";
            } else {
                return "redirect:/login";
            }
        }




   
    //LOGOUT 
  
    @GetMapping("/logout")
    public String pasienLogout(HttpServletRequest request) {

        if (request.getSession().getAttribute("Pasien") != null) {
            request.getSession().invalidate();
        }

        return "redirect:/login";
    }



   
    //HALAMAN CRUD PASIEN
    
    @GetMapping({"/pasien", "/pasien/"})
    public String pasienPage(Model model, HttpServletRequest request) {

        // Jika belum login → lempar ke login
        if (request.getSession().getAttribute("Pasien") == null) {
            return "redirect:/login";
        }

        List<Pasien> pasienList = pasienService.getAllPasien();
        model.addAttribute("pasienList", pasienList);
        model.addAttribute("pasienRec", new Pasien());
        return "pasien.html";
    }

    @GetMapping("/pasien/{id}")
    public String pasienGetRec(Model model,
                               @PathVariable("id") Long id,
                               HttpServletRequest request) {

        if (request.getSession().getAttribute("Pasien") == null) {
            return "redirect:/login";
        }

        List<Pasien> pasienList = pasienService.getAllPasien();
        Pasien pasienRec = pasienService.getPasienById(id);

        model.addAttribute("pasienList", pasienList);
        model.addAttribute("pasienRec", pasienRec);

        return "pasien.html";
    }

    @PostMapping(value = {"/pasien/submit"}, params = {"add"})
    public String pasienAdd(@ModelAttribute("pasienRec") Pasien pasienRec,
                            HttpServletRequest request) {

        if (request.getSession().getAttribute("Pasien") == null) {
            return "redirect:/login";
        }

        pasienService.addPasien(pasienRec);
        return "redirect:/pasien";
    }

    @PostMapping(value = "/pasien/submit/{id}", params = {"edit"})
    public String pasienEdit(@ModelAttribute("pasienRec") Pasien pasienRec,
                             @PathVariable("id") Long id,
                             HttpServletRequest request) {

        if (request.getSession().getAttribute("Pasien") == null) {
            return "redirect:/login";
        }

        pasienService.updatePasien(id, pasienRec);
        return "redirect:/pasien";
    }

    @PostMapping(value = "/pasien/submit/{id}", params = {"delete"})
    public String pasienDelete(@PathVariable("id") Long id,
                               HttpServletRequest request) {

        if (request.getSession().getAttribute("Pasien") == null) {
            return "redirect:/login";
        }

        pasienService.deletePasien(id);
        return "redirect:/pasien";
    }
}
