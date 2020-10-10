package com.gimnasio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimnasio.app.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>  {

}
