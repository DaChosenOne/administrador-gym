package com.gimnasio.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.models.Inscripcion;
import com.gimnasio.app.repository.ClienteRepository;
import com.gimnasio.app.repository.InscripcioneRepository;

@Controller
@RequestMapping("/inscripciones")
public class InscripcionController{
	
	
	@Autowired
	private InscripcioneRepository inscripcionesRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@GetMapping("/")
	public String indexInscriciones(Model model) {
		model.addAttribute("inscripciones", inscripcionesRepository.findAll());
		model.addAttribute("titulo","Seccion de inscripciones");
		return "inscripciones/principal";
	}
	
	@GetMapping("/agregar")
	public String agregarInscriciones(Model model) {
		model.addAttribute("inscripcion", new Inscripcion());
		model.addAttribute("titulo","Agregar inscripcion");
		model.addAttribute("clientes",clienteRepository.findAll());
		return "inscripciones/crear";
	}
	
	@PostMapping("/agregar")
	public String agregarPorInscriciones(Model model,@RequestParam Long idCliente,@RequestParam String fechaInicio,@RequestParam String fechaConclusion) throws ParseException {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCliente(clienteRepository.findById(idCliente).get());
	    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
	    Date fecha1=formatter1.parse(fechaInicio);
	    Date fecha2=formatter1.parse(fechaConclusion);
		inscripcion.setFechaInicio(fecha1); 
		inscripcion.setFechaConclusion(fecha2);
		inscripcionesRepository.save(inscripcion);
		return "redirect:/inscripciones/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarInscripcion(@PathVariable Long id) {
		inscripcionesRepository.deleteById(id);
		return "redirect:/inscripciones/";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizarInscripcion(@PathVariable Long id,Model model) {
		Inscripcion inscripcion = inscripcionesRepository.findById(id).get();
		model.addAttribute("titulo","Actualizar cliente");
		model.addAttribute("inscripcion",inscripcion);
		return "inscripciones/actualizar";
	}
	
	
	@PostMapping("/actualizar")
	public String actualizarPorInscriciones(Model model,@RequestParam Long id,@RequestParam String fechaInicio,@RequestParam String fechaConclusion) throws ParseException {
		Inscripcion inscripcion = inscripcionesRepository.findById(id).get();
	    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
	    Date fecha1=formatter1.parse(fechaInicio);
	    Date fecha2=formatter1.parse(fechaConclusion);
		inscripcion.setFechaInicio(fecha1); 
		inscripcion.setFechaConclusion(fecha2);
		inscripcionesRepository.save(inscripcion);
		return "redirect:/inscripciones/";
	}


}