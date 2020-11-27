package com.gimnasio.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mensualidades_id")
	List<Mensualidad> inscripciones;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "pagos_id")
	List<Pago> pagos;
    
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Inscripcion inscripcion;
    
    
	public Cliente() {
    	
    }

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
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

	public List<Pago> getPagos() {
		return pagos;
	}

	public void agregarPago(Pago pago) {
		if(this.pagos==null){
			this.pagos = new ArrayList<>();
		}else{
			this.pagos.add(pago);
		}
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", telefono="
				+ telefono + "]";
	}


	
	
}
