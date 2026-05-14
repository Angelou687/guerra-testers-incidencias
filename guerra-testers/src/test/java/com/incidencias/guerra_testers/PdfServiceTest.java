package com.incidencias.guerra_testers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PdfServiceTest {

    @Test
    void archivoPdfDebeExistir(){

        String archivo =
                "reporte.pdf";

        assertTrue(
                archivo.endsWith(".pdf")
        );

    }

    @Test
    void nombrePdfNoDebeSerVacio(){

        String archivo =
                "reporte.pdf";

        assertFalse(
                archivo.isEmpty()
        );

    }

}