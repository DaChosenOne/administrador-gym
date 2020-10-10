package com.gimnasio.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.app.models.Producto;
import com.gimnasio.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Producto buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(new Producto());
	}

	@Override
	public void eliminarProductoPorSku(String sku) {
		// TODO Auto-generated method stub
		Producto p = productoRepository.findBySku(sku);
		if(p != null) {
			productoRepository.delete(p);
		}
		
	}

}
