package com.gimnasio.app.controllers;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.models.Pago;
import com.gimnasio.app.repository.ClienteRepository;
import com.gimnasio.app.repository.PagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pagos")
@AllArgsConstructor
public class PagoController {

    private ClienteRepository clienteRepository;
    private PagoRepository pagoRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clientes",clienteRepository.findAll());
        model.addAttribute("titulo","Pagos");
        return "pagos/index";
    }

    @GetMapping("/agregar/{idCliente}")
    public String agregar(Model model, @PathVariable Long idCliente){
        model.addAttribute("titulo","Agregar pago a cliente");
        model.addAttribute("idCliente",idCliente);
        model.addAttribute("nombre",clienteRepository.findById(idCliente).get().getNombre());
        return "pagos/agregar";
    }

    @PostMapping("/agregar")
    public String agregarPost(@RequestParam Long idCliente,@RequestParam String fechaPago,@RequestParam Integer cantidad,@RequestParam String concepto) throws ParseException {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        Pago pago = new Pago();

        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1=formatter1.parse(fechaPago);

        pago.setCliente(cliente);
        pago.setConcepto(cantidad);
        pago.setMotivo(concepto);
        pago.setFechaPago(fecha1);

        cliente.agregarPago(pago);
        clienteRepository.save(cliente);
        return "redirect:/pagos/";
    }

    @GetMapping("/mostrar/{idCliente}")
    public String mostrar(@PathVariable Long idCliente,Model model) throws ParseException {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        model.addAttribute("titulo","Pagos de cliente");
        model.addAttribute("cliente",cliente);
        return "pagos/mostrar";
    }



}
