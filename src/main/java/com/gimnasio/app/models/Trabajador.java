package com.gimnasio.app.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "trabajadores")
public class Trabajador implements Serializable {

	private static final long serialVersionUID = 1L;

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(name = "email")
	    private String correo;
	    
	    @Column(name = "password")
	    private String password;

	    @Column(name = "rol")
	    @Enumerated(EnumType.STRING)
	    private Rol role;

	    private Boolean activo;
	    
	
		public Trabajador(Long id, String correo, String password, Rol role, Boolean activo) {
			this.id = id;
			this.correo = correo;
			this.password = password;
			this.role = role;
			this.activo = activo;
		}

		public Trabajador() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Rol getRole() {
			return role;
		}

		public void setRole(Rol role) {
			this.role = role;
		}

		public Boolean getActivo() {
			return activo;
		}

		public void setActivo(Boolean activo) {
			this.activo = activo;
		}

		@Override
		public String toString() {
			return "Trabajador [id=" + id + ", correo=" + correo + ", password=" + password + ", role=" + role
					+ ", activo=" + activo + "]";
		}
	
		
	    
}
