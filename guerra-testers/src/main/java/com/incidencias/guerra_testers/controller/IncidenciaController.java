package com.incidencias.guerra_testers.controller;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.repository.IncidenciaRepository;

import com.incidencias.guerra_testers.service.PdfService;
import com.incidencias.guerra_testers.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;

import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;

import java.util.List;

@RestController

@RequestMapping("/incidencias")

@CrossOrigin("*")

public class IncidenciaController {

    @Autowired
    private IncidenciaRepository repository;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private LogService logService;

    @GetMapping
    public List<Incidencia> listar() {

        return repository.findAll();

    }

    @PostMapping
    public Incidencia guardar(
            @RequestBody Incidencia incidencia
    ) {

        Incidencia guardada =
                repository.save(incidencia);

        logService.guardarLog(
                "Incidencia creada: "
                + guardada.getTitulo()
        );

        return guardada;

    }

    @PutMapping("/{id}")
    public Incidencia actualizar(
            @PathVariable Long id,
            @RequestBody Incidencia incidencia
    ) {

        incidencia.setId(id);

        Incidencia actualizada =
                repository.save(incidencia);

        logService.guardarLog(
                "Incidencia actualizada: "
                + actualizada.getTitulo()
        );

        return actualizada;

    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id
    ) {

        Incidencia incidencia =
                repository.findById(id)
                .orElse(null);

        if(incidencia != null){

            logService.guardarLog(
                    "Incidencia eliminada: "
                    + incidencia.getTitulo()
            );

            repository.deleteById(id);

        }

    }

    @GetMapping("/buscar")
    public List<Incidencia> buscarPorTitulo(
            @RequestParam String titulo
    ) {

        return repository
                .findByTituloContainingIgnoreCase(
                        titulo
                );

    }

    @GetMapping("/prioridad")
    public List<Incidencia> filtrarPorPrioridad(
            @RequestParam String prioridad
    ) {

        return repository
                .findByPrioridad(prioridad);

    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> exportarPdf() {

        ByteArrayInputStream pdf =
                pdfService.generarPdf();

        HttpHeaders headers =
                new HttpHeaders();

        headers.add(
                "Content-Disposition",
                "inline; filename=incidencias.pdf"
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(
                        new InputStreamResource(pdf)
                );

    }

}