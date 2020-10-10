package com.gimnasio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimnasio.app.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
