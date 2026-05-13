package com.incidencias.guerra_testers.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;

@Controller
public class LogController {

    @GetMapping("/historial")
    public String historial(){

        return "historial";

    }

    @ResponseBody
    @GetMapping("/logs")
    public String logs(){

        try{

            ClassPathResource resource =
                    new ClassPathResource(
                            "logs/logs.txt"
                    );

            return Files.readString(
                    resource.getFile().toPath()
            );

        }
        catch(Exception e){

            return "No se pudieron cargar logs";

        }

    }

}