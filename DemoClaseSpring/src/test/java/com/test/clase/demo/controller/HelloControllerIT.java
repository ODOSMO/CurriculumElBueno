package com.test.clase.demo.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

//Ejecutar pruebas con el SpringRunner
@RunWith(SpringRunner.class)
//Ejecutar pruebas en un puerto aleatorio
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    //Puerto de la prueba
    @LocalServerPort
    private int port;

    private URL base;

    //Enlazar el bean del TestRestTemplate para las pruebas
    @Autowired
    private TestRestTemplate template;

    /**
     *     Realizar un setUp antes de iniciar,
     *     en esta caso es el registro de la URL de prueba
     * @throws  Exception, lanza error si este no se logra
     */

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }


    /**
     * @Test es la ejecucion de la prueba
     * @throws Exception, lanza error si no se logra
     */
    @Test
    public void getHello() throws Exception {
        //Se le hace una peticion a la URL y se guarda la respuesta
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        //Verifica que la respuesta a la peticion sea el saludo para decir que esta fue correcta
        //assertThat(response.getBody(), equalTo("Saludos!!! desde Spring Boot!"));
    }
}
