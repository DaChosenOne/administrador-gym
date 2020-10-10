package com.gimnasio.app.services;

import java.util.List;

import com.gimnasio.app.models.Producto;

public interface ProductoService {

	List<Producto> listarProductos();
	void eliminarProducto(Long id);
	Producto guardarProducto(Producto producto);
	Producto buscarPorId(Long id);
	void eliminarProductoPorSku(String sku);
}
