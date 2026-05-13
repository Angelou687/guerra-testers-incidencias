package com.incidencias.guerra_testers;

import com.incidencias.guerra_testers.service.LogService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LogServiceTest {

    @Autowired
    private LogService logService;

    @Test
    void guardarLog(){

        assertDoesNotThrow(() -> {

            logService.guardarLog("TEST LOG");

        });

    }

}