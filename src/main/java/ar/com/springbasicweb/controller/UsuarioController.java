package ar.com.springbasicweb.controller;

import ar.com.springbasicweb.beans.Usuario;
import ar.com.springbasicweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/usuario")
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuario";
    }

    @RequestMapping("/usuario/save")
    public String register(@ModelAttribute("usuario") Usuario usuarioForm,
            Model model) {

        usuarioService.save(usuarioForm);

        return "redirect:/usuario";
    }

}
