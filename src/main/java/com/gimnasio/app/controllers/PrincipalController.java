package com.gimnasio.app.controllers;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.models.Inscripcion;
import com.gimnasio.app.repository.ClienteRepository;
import com.gimnasio.app.repository.InscripcioneRepository;
import com.gimnasio.app.services.EmailBody;
import com.gimnasio.app.services.EmailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PrincipalController {

    @Autowired
    private EmailPort emailPort;

    @Autowired
    private InscripcioneRepository inscripcioneRepository;

    @GetMapping("/")
    public String paginaPrincipal(Model model){
        List<Cliente> clienteList = new ArrayList<>();
        for (Inscripcion inscripcion : inscripcioneRepository.findAll()) {
            if (new Date().after(inscripcion.getFechaConclusion())) {
                clienteList.add(inscripcion.getCliente());
            }
        }


        model.addAttribute("titulo","Pagina Principal");
        model.addAttribute("url","/");
        model.addAttribute("clientes",clienteList);
        return "principal/index.html";
    }


}
