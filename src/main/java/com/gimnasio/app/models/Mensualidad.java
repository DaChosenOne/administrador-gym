package com.gimnasio.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name = "mensualidades")
public class Mensualidad implements Serializable {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date fechaConclusion;
	
	Cliente cliente;
	
	public Mensualidad() {
		
	}

	public Mensualidad(Long id, Date fechaInicio, Date fechaConclusion, Cliente cliente) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaConclusion = fechaConclusion;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaConclusion() {
		return fechaConclusion;
	}

	public void setFechaConclusion(Date fechaConclusion) {
		this.fechaConclusion = fechaConclusion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Mensualidad [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaConclusion=" + fechaConclusion
				+ ", cliente=" + cliente + "]";
	}
	
	

}
