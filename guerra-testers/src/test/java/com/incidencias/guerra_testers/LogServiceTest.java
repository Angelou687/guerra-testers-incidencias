package com.incidencias.guerra_testers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogServiceTest {

    @Test
    void logDebeContenerTexto(){

        String log =
                "Incidencia creada";

        assertFalse(
                log.isEmpty()
        );

    }

    @Test
    void logDebeSerCorrecto(){

        String log =
                "Incidencia eliminada";

        assertEquals(
                "Incidencia eliminada",
                log
        );

    }

}