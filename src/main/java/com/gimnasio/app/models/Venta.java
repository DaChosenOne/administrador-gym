package com.gimnasio.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "ventas")
public class Venta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
	private Long id;
	
	
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_venta")
	private Date fechaVenta;
	
	private String observaciones;
	
	private Long descuento;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemVenta> items = new ArrayList<ItemVenta>();
	
	private Double pagoTotal;
	
	
	@PrePersist
	public void prePersist(){
		this.fechaVenta = new Date();
	}
	
	
	
	public Venta(Long id, String nombre, Date fechaVenta, String observaciones, Long descuento, List<ItemVenta> items,
			Double pagoTotal) {
		this.id = id;
		this.nombre = nombre;
		this.fechaVenta = fechaVenta;
		this.observaciones = observaciones;
		this.descuento = descuento;
		this.items = items;
		this.pagoTotal = pagoTotal;
	}



	public Venta() {
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

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getDescuento() {
		return descuento;
	}

	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}

	public List<ItemVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemVenta> items) {
		this.items = items;
	}

	public Double getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(Double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	
	public void addItemVenta(ItemVenta item) {
		this.items.add(item);
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(ItemVenta item: items) {
			total+= item.calcularImporte();
		}
		total-=this.descuento;
		return total;
	}



	@Override
	public String toString() {
		return "Venta [id=" + id + ", nombre=" + nombre + ", fechaVenta=" + fechaVenta + ", observaciones="
				+ observaciones + ", descuento=" + descuento + ", items=" + items + ", pagoTotal=" + pagoTotal + "]";
	}
	
	
	
}
