package com.gimnasio.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.app.models.Trabajador;
import com.gimnasio.app.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Override
	public List<Trabajador> listarTrabajadores() {
		// TODO Auto-generated method stub
		return trabajadorRepository.findAll();
	}

	@Override
	public Trabajador buscarTrabajadorPorId(Long id) {
		// TODO Auto-generated method stub
		return trabajadorRepository.findById(id).orElse(new Trabajador());
	}

	@Override
	public void eliminarTrabajador(Long idTrabajador) {
		// TODO Auto-generated method stub
		trabajadorRepository.deleteById(idTrabajador);
		
	}

	@Override
	public Trabajador crearTrabajador(Trabajador trabajador) {
		// TODO Auto-generated method stub
		return trabajadorRepository.save(trabajador);
	}

}
