package com.incidencias.guerra_testers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incidencias.guerra_testers.model.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

    List<Incidencia> findByTituloContainingIgnoreCase(String titulo);

}