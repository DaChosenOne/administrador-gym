package com.gimnasio.app.controllers;


import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.services.ClienteService;
import com.gimnasio.app.utils.ZXingHelper;



@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String paginaPrincipal(Model model) {
		List<Cliente> clientes = clienteService.listarClientes();
		for(Cliente cliente:clientes) {
			if(cliente.getFechaTermino().before(new Date())) {
				cliente.setActivo(false);
				clienteService.crearCliente(cliente);
			}
		}
		
		model.addAttribute("clientes", clientes);
		model.addAttribute("titulo","Seccion de clientes");
		return "clientes/principal";
	}
	
	@GetMapping("/agregar-cliente")
	public String agregarTrabajador(Model model) {
		model.addAttribute("titulo","Agregar Cliente");
		model.addAttribute("cliente",new Cliente());
		return "clientes/agregar";
	}
	
	@PostMapping("/agregar-cliente")
	public String guardarTrabajador(@ModelAttribute Cliente cliente) {
		clienteService.crearCliente(cliente);
	      return "redirect:/clientes/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable Long id) {
	      clienteService.eliminarCliente(id);
	      return "redirect:/clientes/";
	}
	
	@GetMapping("/actualizar/{id}")
	public String redirigeDatos(Model model,@PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		model.addAttribute("cliente",cliente);
		model.addAttribute("titulo","Actualizar trabajador");
		return "clientes/actualizar";
	}
	
    @GetMapping("/generar-qr/{id}")
	public void generarQR(@PathVariable Long id, HttpServletResponse response) throws Exception {
    	String url = "https://cyignus.com/generar-qr.php?id=" + id;
    	response.setContentType("image/png");
    	OutputStream outputStream = response.getOutputStream();
    	outputStream.write(ZXingHelper.getQRCodeImage(url, 300, 300));
    	outputStream.flush();
    	outputStream.close();		
	}
    
  
	
	
	
}
