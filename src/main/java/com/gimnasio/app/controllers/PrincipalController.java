package com.gimnasio.app.controllers;

import com.gimnasio.app.services.EmailBody;
import com.gimnasio.app.services.EmailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrincipalController {

    @Autowired
    private EmailPort emailPort;

    @GetMapping("/")
    public String paginaPrincipal(Model model){
        model.addAttribute("titulo","Pagina Principal");
        model.addAttribute("url","/");
        return "principal/index.html";
    }


}
