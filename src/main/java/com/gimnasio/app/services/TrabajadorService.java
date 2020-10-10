package com.gimnasio.app.services;

import com.gimnasio.app.models.Trabajador;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface TrabajadorService extends UserDetailsService{

    List<Trabajador> listarTrabajadores();
    Trabajador buscarTrabajadorPorId(Long id);
    void eliminarTrabajador(Long idTrabajador);
    Trabajador crearTrabajador(Trabajador trabajador);
    Trabajador findByCorreo(String correo);
}
