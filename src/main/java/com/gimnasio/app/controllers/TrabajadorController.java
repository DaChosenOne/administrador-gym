package com.gimnasio.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gimnasio.app.models.Trabajador;
import com.gimnasio.app.services.TrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {
	
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping("/")
	public String paginaPrincipal(Model model) {
		List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();
		model.addAttribute("trabajadores", trabajadores);
		model.addAttribute("titulo","Seccion de trabajadores");
			
		return "trabajadores/principal";
	}
	
	@GetMapping("/agregar-trabajador")
	public String agregarTrabajador(Model model) {
		model.addAttribute("titulo","Agregar Trabajador");
		model.addAttribute("trabajador",new Trabajador());
		return "trabajadores/agregar";
	}
	
	@PostMapping("/agregar-trabajador")
	public String guardarTrabajador(@ModelAttribute Trabajador trabajador) {
		trabajadorService.crearTrabajador(trabajador);
	      return "redirect:/trabajadores/";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminarTrabajador(@PathVariable Long id) {
	      trabajadorService.eliminarTrabajador(id);
	      return "redirect:/trabajadores/";
	}
	
	@GetMapping("/actualizar/{id}")
	public String redirigeDatos(Model model,@PathVariable Long id) {
		Trabajador trabajador = trabajadorService.buscarTrabajadorPorId(id);
		model.addAttribute("trabajador",trabajador);
		model.addAttribute("titulo","Actualizar trabajador");
		return "trabajadores/actualizar";
	}


}
