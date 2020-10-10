package com.gimnasio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimnasio.app.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
		Producto findBySku(String sku);
}
