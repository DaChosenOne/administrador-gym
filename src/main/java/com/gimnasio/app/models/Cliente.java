package com.gimnasio.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "clientes")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
    
	String nombre;
	
	@Column(name = "email")
    String correoElectronico;
    
    String telefono;
    
    @Column(name = "fecha_inico")
    @Temporal(TemporalType.DATE)
    Date fechaInicio;
    
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    Date fechaTermino;
    
    boolean activo = true ;

    
    
    public Cliente(Long id, String nombre, String correoElectronico, String telefono, Date fechaInicio,
			Date fechaTermino, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.activo = activo;
	}

	public Cliente() {
    	
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", telefono="
				+ telefono + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", activo=" + activo
				+ "]";
	}

	
}
