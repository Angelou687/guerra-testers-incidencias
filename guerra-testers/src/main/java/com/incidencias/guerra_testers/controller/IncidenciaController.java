package com.incidencias.guerra_testers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.service.IncidenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/incidencias")
@CrossOrigin("*")
public class IncidenciaController {

    @Autowired
    private IncidenciaService service;

    @GetMapping
    public List<Incidencia> listar() {

        return service.listar();

    }

    @GetMapping("/buscar")
    public List<Incidencia> buscar(@RequestParam String titulo){

        return service.buscarPorTitulo(titulo);

    }

    @PostMapping
    public Incidencia guardar(
            @Valid @RequestBody Incidencia incidencia) {

        return service.guardar(incidencia);

    }

    @PutMapping("/{id}")
    public Incidencia actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Incidencia incidencia) {

        return service.actualizar(id, incidencia);

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        service.eliminar(id);

    }

}