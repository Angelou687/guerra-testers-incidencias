package com.incidencias.guerra_testers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.incidencias.guerra_testers.model.Incidencia;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IncidenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void listarIncidencias() throws Exception {

        mockMvc.perform(get("/incidencias"))
                .andExpect(status().isOk());

    }

    @Test
    void guardarIncidencia() throws Exception {

        Incidencia incidencia = new Incidencia();

        incidencia.setTitulo("Error API");
        incidencia.setDescripcion("Error grave");
        incidencia.setPrioridad("Alta");
        incidencia.setEstado("Pendiente");
        incidencia.setSucursal("Lima");
        incidencia.setUsuario("Tester");

        mockMvc.perform(post("/incidencias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        objectMapper.writeValueAsString(
                                incidencia
                        )
                ))
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$.titulo")
                                .value("Error API")
                );

    }

    @Test
    void buscarIncidencia() throws Exception {

        mockMvc.perform(get("/incidencias/buscar")
                .param("titulo","Error"))
                .andExpect(status().isOk());

    }

    @Test
    void filtrarPrioridad() throws Exception {

        mockMvc.perform(get("/incidencias/prioridad")
                .param("prioridad","Alta"))
                .andExpect(status().isOk());

    }

    @Test
    void exportarPdf() throws Exception {

        mockMvc.perform(get("/incidencias/pdf"))
                .andExpect(status().isOk())
                .andExpect(
                        content()
                                .contentType("application/pdf")
                );

    }

}