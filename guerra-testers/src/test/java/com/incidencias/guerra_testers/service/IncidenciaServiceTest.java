package com.incidencias.guerra_testers.service;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.repository.IncidenciaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IncidenciaServiceTest {

    @Mock
    private IncidenciaRepository repository;

    @InjectMocks
    private IncidenciaService service;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void deberiaGuardarIncidenciaCorrectamente() {

        Incidencia incidencia = new Incidencia();

        incidencia.setTitulo("Error Login");
        incidencia.setDescripcion("No permite ingresar");
        incidencia.setPrioridad("Alta");
        incidencia.setEstado("Pendiente");
        incidencia.setSucursal("Arequipa");
        incidencia.setUsuario("Angel");
        incidencia.setFecha(LocalDate.now());

        when(repository.save(any(Incidencia.class)))
                .thenReturn(incidencia);

        Incidencia resultado = service.guardar(incidencia);

        assertNotNull(resultado);

        assertEquals("Error Login", resultado.getTitulo());

        verify(repository, times(1))
                .save(any(Incidencia.class));

    }

    @Test
    void noDeberiaGuardarTituloVacio() {

        Incidencia incidencia = new Incidencia();

        incidencia.setTitulo("");

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.guardar(incidencia)
        );

        assertEquals("Titulo obligatorio",
                exception.getMessage());

    }

}