package com.gimnasio.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @GetMapping("/")
    public String paginaPrincipal(Model model){
        model.addAttribute("titulo","Pagina Principal");
        model.addAttribute("url","/");
        return "principal/index.html";
    }

}
