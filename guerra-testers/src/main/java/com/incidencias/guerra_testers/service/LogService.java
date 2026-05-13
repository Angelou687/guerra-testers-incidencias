package com.incidencias.guerra_testers.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;

@Service
public class LogService {

    private final String ruta =
            "src/main/resources/logs/logs.txt";

    public void guardarLog(String accion){

        try{

            FileWriter writer =
                    new FileWriter(ruta,true);

            writer.write(
                    LocalDateTime.now()
                    + " -> "
                    + accion
                    + "\n"
            );

            writer.close();

        }
        catch(IOException e){

            e.printStackTrace();

        }

    }

}