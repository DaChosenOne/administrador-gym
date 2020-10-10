package com.gimnasio.app.services;

import java.util.List;

import com.gimnasio.app.models.Cliente;

public interface ClienteService {
	
	List<Cliente> listarClientes();
	Cliente buscarClientePorId(Long idCliente);
	void eliminarCliente(Long idCliente);
	void crearCliente(Cliente cliente);

}
