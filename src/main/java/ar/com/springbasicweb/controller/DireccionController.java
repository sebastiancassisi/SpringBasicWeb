/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.controller;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.beans.Direccion;
import ar.com.springbasicweb.service.AdminService;
import ar.com.springbasicweb.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("admin")
public class DireccionController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private DireccionService direccionService;

    @RequestMapping("/direccion/{idAd}")
    public String getAll(Model model,
            @ModelAttribute("resultado") String resultado,
            @PathVariable("idAd") int idAd) {

        Admin admin = adminService.findById(idAd);
        model.addAttribute("admin", admin);

        model.addAttribute("direccion", new Direccion());
        model.addAttribute("resltado", resultado);
        model.addAttribute("direcciones", direccionService.findAll(idAd));

        return "direccion";
    }

    @RequestMapping("/direccion/save")
    public String save(Model model, RedirectAttributes ra,
            @ModelAttribute("direccion") Direccion direccion,
            @ModelAttribute("admin") Admin admin) {

        direccionService.save(admin, direccion);
        ra.addFlashAttribute("resultado", "Cambios realizados con exito");
        return "redirect:/direccion/" + admin.getIdAd();
    }

}
