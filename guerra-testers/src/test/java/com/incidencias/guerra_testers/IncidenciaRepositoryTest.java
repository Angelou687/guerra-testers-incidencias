package com.incidencias.guerra_testers;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.repository.IncidenciaRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IncidenciaRepositoryTest {

    @Autowired
    private IncidenciaRepository repository;

    @Test
    void guardarIncidencia(){

        Incidencia incidencia = crearIncidencia();

        Incidencia guardada =
                repository.save(incidencia);

        assertNotNull(guardada.getId());

    }

    @Test
    void listarIncidencias(){

        Incidencia incidencia =
                crearIncidencia();

        repository.save(incidencia);

        List<Incidencia> lista =
                repository.findAll();

        assertTrue(lista.size() > 0);

    }

    @Test
    void buscarPorTitulo(){

        Incidencia incidencia =
                crearIncidencia();

        incidencia.setTitulo("Error Critico");

        repository.save(incidencia);

        List<Incidencia> lista =
                repository
                        .findByTituloContainingIgnoreCase(
                                "Error"
                        );

        assertFalse(lista.isEmpty());

    }

    @Test
    void filtrarPrioridad(){

        Incidencia incidencia =
                crearIncidencia();

        incidencia.setPrioridad("Alta");

        repository.save(incidencia);

        List<Incidencia> lista =
                repository.findByPrioridad("Alta");

        assertFalse(lista.isEmpty());

    }

    private Incidencia crearIncidencia(){

        Incidencia incidencia =
                new Incidencia();

        incidencia.setTitulo("Error Login");

        incidencia.setDescripcion(
                "No permite ingresar"
        );

        incidencia.setPrioridad("Alta");

        incidencia.setEstado("Pendiente");

        incidencia.setSucursal("Arequipa");

        incidencia.setUsuario("Angel");

        return incidencia;

    }

}