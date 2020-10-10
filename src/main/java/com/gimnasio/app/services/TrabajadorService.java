package com.gimnasio.app.services;

import com.gimnasio.app.models.Trabajador;

import java.util.List;

public interface TrabajadorService {

    List<Trabajador> listarTrabajadores();
    Trabajador buscarTrabajadorPorId(Long id);
    void eliminarTrabajador(Long idTrabajador);
    Trabajador crearTrabajador(Trabajador trabajador);
}
