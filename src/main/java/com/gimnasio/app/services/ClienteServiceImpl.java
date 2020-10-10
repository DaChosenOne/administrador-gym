package com.gimnasio.app.services;

import java.util.List;

import com.gimnasio.app.models.Cliente;
import com.gimnasio.app.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarClientePorId(Long idCliente) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(idCliente).orElse(new Cliente());
	}

	@Override
	public void eliminarCliente(Long idCliente) {
		clienteRepository.deleteById(idCliente);
		
	}

	@Override
	public void crearCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}




}
