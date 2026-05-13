package com.incidencias.guerra_testers;

import com.incidencias.guerra_testers.service.PdfService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PdfServiceTest {

    @Autowired
    private PdfService pdfService;

    @Test
    void generarPdf(){

        ByteArrayInputStream pdf =
                pdfService.generarPdf();

        assertNotNull(pdf);

    }

}