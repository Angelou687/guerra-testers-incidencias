package com.incidencias.guerra_testers.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.repository.IncidenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    @Autowired
    private IncidenciaRepository repository;

    public ByteArrayInputStream generarPdf(){

        Document document = new Document();

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        try{

            PdfWriter.getInstance(document, out);

            document.open();

            Font fontTitulo =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            18
                    );

            Paragraph titulo =
                    new Paragraph(
                            "Reporte de Incidencias",
                            fontTitulo
                    );

            titulo.setAlignment(Element.ALIGN_CENTER);

            document.add(titulo);

            document.add(Chunk.NEWLINE);

            PdfPTable tabla =
                    new PdfPTable(6);

            tabla.setWidthPercentage(100);

            tabla.addCell("Titulo");
            tabla.addCell("Descripción");
            tabla.addCell("Prioridad");
            tabla.addCell("Estado");
            tabla.addCell("Sucursal");
            tabla.addCell("Usuario");

            List<Incidencia> incidencias =
                    repository.findAll();

            for(Incidencia i : incidencias){

                tabla.addCell(i.getTitulo());
                tabla.addCell(i.getDescripcion());
                tabla.addCell(i.getPrioridad());
                tabla.addCell(i.getEstado());
                tabla.addCell(i.getSucursal());
                tabla.addCell(i.getUsuario());

            }

            document.add(tabla);

            document.close();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return new ByteArrayInputStream(
                out.toByteArray()
        );

    }

}