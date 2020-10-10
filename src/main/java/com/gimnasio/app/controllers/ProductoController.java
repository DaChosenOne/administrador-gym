package com.gimnasio.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gimnasio.app.models.Producto;
import com.gimnasio.app.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/")
	public String paginaPrincipal(Model model) {
		List<Producto> productos = productoService.listarProductos();
		model.addAttribute("productos", productos);
		model.addAttribute("producto",new Producto());
		model.addAttribute("titulo","Seccion de productos");
		return "productos/principal";
	}
	
	@PostMapping("/agregar-producto")
	public String agregarProducto(@ModelAttribute Producto producto) {
		productoService.guardarProducto(producto);
		 return "redirect:/productos/";	
	}
	
	@PostMapping("/eliminar-producto")
	public String eliminarProducto(@RequestParam(name = "sku") String sku) {
		 productoService.eliminarProductoPorSku(sku);
		 return "redirect:/productos/";	
	}
	
	@PostMapping("/actualizar-producto")
	public String actualizarProducto(@RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "id") Long id,
			@RequestParam(name = "cantidad") Long cantidad,
			@RequestParam(name = "marca") String marca,
			@RequestParam(name = "categoria") String categoria,
			@RequestParam(name = "precio") Long precio,
			@RequestParam(name = "sku") String sku) {
		
		Producto p = new Producto();
		p.setCantidad(cantidad);
		p.setCategoria(categoria);
		p.setId(id);
		p.setMarca(marca);
		p.setNombre(nombre);
		p.setSku(sku);
		p.setPrecio(precio);
	
		productoService.guardarProducto(p);

		return "redirect:/productos/";
	}

}
