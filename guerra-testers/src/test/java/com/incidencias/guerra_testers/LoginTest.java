package com.incidencias.guerra_testers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void loginAdminCorrecto(){

        String usuario = "admin";
        String password = "123";

        assertEquals("admin", usuario);

        assertEquals("123", password);

    }

    @Test
    void loginUserCorrecto(){

        String usuario = "user";
        String password = "123";

        assertEquals("user", usuario);

        assertEquals("123", password);

    }

    @Test
    void loginIncorrecto(){

        String usuario = "fake";

        assertNotEquals("admin", usuario);

    }

    @Test
    void passwordIncorrecto(){

        String password = "000";

        assertNotEquals("123", password);

    }

}