package com.gimnasio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gimnasio.app.models.Inscripcion;

public interface InscripcioneRepository extends JpaRepository<Inscripcion, Long>  {

}
