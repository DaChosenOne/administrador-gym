package com.gimnasio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimnasio.app.models.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    Trabajador findByCorreoAndPassword(String correo,String password);
    Trabajador findByCorreo(String correo);

}
