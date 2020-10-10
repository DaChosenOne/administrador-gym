package com.gimnasio.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long cantidad;
	private Long precio;
	private String categoria;
	private String marca;
	private String sku;
	
	public Producto() {
		
	}

	public Producto(Long id, String nombre, Long cantidad, Long precio, String categoria, String marca, String sku) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.categoria = categoria;
		this.marca = marca;
		this.sku = sku;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public Long getPrecio() {
		return precio;
	}


	public void setPrecio(Long precio) {
		this.precio = precio;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", categoria=" + categoria + ", marca=" + marca + "]";
	}
	
	
}
