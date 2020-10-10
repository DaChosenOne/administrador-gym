package com.gimnasio.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gimnasio.app.models.ItemVenta;
import com.gimnasio.app.models.Venta;
import com.gimnasio.app.repository.ProductoRepository;
import com.gimnasio.app.repository.VentaRepository;

@Controller
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private VentaRepository ventasRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@GetMapping("/")
	public String principal(Model model) {
		List<Venta> ventas = ventasRepository.findAll();
		model.addAttribute("ventas", ventas);
		model.addAttribute("titulo","Seccion de ventas");
		return "ventas/principal";
	}
	
	@GetMapping("/ticket/{id}")
	public String principal2(@PathVariable Long id, Model model) {
		Venta venta = ventasRepository.findById(id).get();
		model.addAttribute("venta",venta );
		return "ventas/ticket";
	}
	
	@GetMapping("/agregar-venta")
	public String agregarVenta(Model model){
		model.addAttribute("titulo","Agregar venta");
		model.addAttribute("productos",productoRepository.findAll());
		return "ventas/crear";
	}
	
	@PostMapping("/agregar-venta")
	public String agregarVentaPost(Model model,@RequestParam(name = "unidad")String[] unidades, @RequestParam(name = "producto")String[] idProductos,
			@RequestParam String nombre,@RequestParam String observaciones,@RequestParam String descuento ) {
		
		Venta venta = new Venta();
		venta.setNombre(nombre);
		venta.setObservaciones(observaciones);
		venta.setDescuento(Long.parseLong(descuento));
		List<ItemVenta> items = new ArrayList<>();
		
		for(int i = 0; i< unidades.length ; i++) {
			 if(!unidades[i].equals("0")) {
				 ItemVenta item = new ItemVenta();
				 item.setCantidad(Integer.parseInt(unidades[i]));
				 item.setProducto(productoRepository.findById(Long.parseLong(idProductos[i])).get());
			     items.add(item);
			 }else {
				 return "redirect:/ventas/"; 
			 }
		venta.setItems(items);
		venta.setPagoTotal(venta.getTotal());	 
		ventasRepository.save(venta);	 
		 }
	
			
		 return "redirect:/ventas/"; 
	}
	
	@GetMapping("/eliminar-venta/{id}")
	public String eliminarVenta(@PathVariable Long id) {
		ventasRepository.deleteById(id);
		return "redirect:/ventas/";
	}
	
	

}
