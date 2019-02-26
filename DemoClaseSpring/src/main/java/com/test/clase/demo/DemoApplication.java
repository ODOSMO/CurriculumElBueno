package com.test.clase.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


    /**
     * Metodo main que ejecuta la aplicacion de SpringBoot con SpringApplication.Run
     * @param args  argumentos extra al ejecutar aplicación
     */
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}

