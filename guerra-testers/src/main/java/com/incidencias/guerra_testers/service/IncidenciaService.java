package com.incidencias.guerra_testers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incidencias.guerra_testers.model.Incidencia;
import com.incidencias.guerra_testers.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository repository;

    public List<Incidencia> listar() {
        return repository.findAll();
    }
    public List<Incidencia> buscarPorTitulo(String titulo){

    return repository.findByTituloContainingIgnoreCase(titulo);

}
    public Incidencia guardar(Incidencia incidencia) {

        if (incidencia.getTitulo() == null || incidencia.getTitulo().isEmpty()) {
            throw new RuntimeException("Titulo obligatorio");
        }

        return repository.save(incidencia);
    }

    public Incidencia actualizar(Long id, Incidencia incidencia) {

        Incidencia actual = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));

        actual.setTitulo(incidencia.getTitulo());
        actual.setDescripcion(incidencia.getDescripcion());
        actual.setPrioridad(incidencia.getPrioridad());
        actual.setEstado(incidencia.getEstado());
        actual.setSucursal(incidencia.getSucursal());
        actual.setUsuario(incidencia.getUsuario());
        actual.setFecha(incidencia.getFecha());

        return repository.save(actual);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}