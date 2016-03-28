/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ANTI
 */
@Controller
@SessionAttributes("resultado")
public class IndexController {
    
    @RequestMapping("/")
    public String showIndex(Model model){
      model.addAttribute("resultado","Resultado desde SessionAttributes");    
    return "index";
    }
    
    @RequestMapping("/about")
    public String showAbout(){
    return "about";
    }
       
}
