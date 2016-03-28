/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.controller;

import ar.com.springbasicweb.beans.Admin;
import ar.com.springbasicweb.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin")
    public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {
        
        List<Admin> admins = adminService.findAll();
        
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        model.addAttribute("resultado", resultado);
        model.addAttribute("admins",admins);
        return "admin";
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public String handleAmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {

        if (adminService.save(adminForm)) {
            ra.addFlashAttribute("resultado", "Cambios realizados con exito");
        } else {
            ra.addFlashAttribute("resultado", "Error al realizar los cambios");
        }
        return "redirect:/admin";
    }
    
    @RequestMapping("/admin/{idAd}/update")
    public String showUpdate(Model model,@PathVariable("idAd") int id){
        Admin admin = adminService.findById(id);
        model.addAttribute("admin",admin);
    
    return "admin";
    }

}
