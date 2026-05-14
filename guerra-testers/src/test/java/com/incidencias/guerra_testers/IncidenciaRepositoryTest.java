package com.incidencias.guerra_testers;

import com.incidencias.guerra_testers.model.Incidencia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncidenciaRepositoryTest {

    @Test
    void crearIncidenciaCorrectamente(){

        Incidencia incidencia =
                new Incidencia();

        incidencia.setTitulo(
                "Error Login"
        );

        incidencia.setDescripcion(
                "No permite ingresar"
        );

        incidencia.setPrioridad(
                "Alta"
        );

        incidencia.setEstado(
                "Pendiente"
        );

        assertEquals(
                "Error Login",
                incidencia.getTitulo()
        );

        assertEquals(
                "Alta",
                incidencia.getPrioridad()
        );

    }

    @Test
    void tituloNoDebeSerVacio(){

        Incidencia incidencia =
                new Incidencia();

        incidencia.setTitulo("");

        assertTrue(
                incidencia.getTitulo().isEmpty()
        );

    }

    @Test
    void prioridadDebeSerAlta(){

        Incidencia incidencia =
                new Incidencia();

        incidencia.setPrioridad(
                "Alta"
        );

        assertEquals(
                "Alta",
                incidencia.getPrioridad()
        );

    }

    @Test
    void estadoDebeSerPendiente(){

        Incidencia incidencia =
                new Incidencia();

        incidencia.setEstado(
                "Pendiente"
        );

        assertEquals(
                "Pendiente",
                incidencia.getEstado()
        );

    }

}