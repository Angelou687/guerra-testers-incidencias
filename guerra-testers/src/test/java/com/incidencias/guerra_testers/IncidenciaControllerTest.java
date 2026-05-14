package com.incidencias.guerra_testers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncidenciaControllerTest {

    @Test
    void endpointPrincipalCorrecto(){

        String endpoint = "/";

        assertEquals("/", endpoint);

    }

    @Test
    void endpointApiCorrecto(){

        String endpoint =
                "/api/incidencias";

        assertTrue(
                endpoint.contains("api")
        );

    }

    @Test
    void endpointEliminarCorrecto(){

        String endpoint =
                "/eliminar/1";

        assertTrue(
                endpoint.contains("eliminar")
        );

    }

    @Test
    void endpointEditarCorrecto(){

        String endpoint =
                "/editar/1";

        assertTrue(
                endpoint.contains("editar")
        );

    }

}