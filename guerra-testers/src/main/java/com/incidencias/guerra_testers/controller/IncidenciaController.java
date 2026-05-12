package com.incidencias.guerra_testers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.service.IncidenciaService;

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

    @PostMapping
    public Incidencia guardar(@RequestBody Incidencia incidencia) {
        return service.guardar(incidencia);
    }

    @PutMapping("/{id}")
    public Incidencia actualizar(@PathVariable Long id,
                                 @RequestBody Incidencia incidencia) {
        return service.actualizar(id, incidencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}