package com.test.clase.demo.controller;

import com.test.clase.demo.model.CurriculumVitae;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class CVController {
    @GetMapping(value = "/datos")
    public String obtenerDatos(Model model){

        CurriculumVitae curri = new CurriculumVitae();
        curri.setFoto("/images/oscarD.jpg");
        curri.setNombre("OSCAR DAVID");
        curri.setApellidoPaterno("SANCHEZ");
        curri.setApellidoMaterno("MUÑOZ");
        curri.setGrado("Lic. en Sistemas Computacionales");

        List<java.lang.String> listaContacto = new ArrayList<java.lang.String>();
        listaContacto.add("Correo: lscodosmo@gmail.com");
        listaContacto.add("Telefono: (686) 309 5922");
        listaContacto.add("Ubicación: Mexicali, Baja California");
        curri.setContacto(listaContacto);

        List<java.lang.String> listaEducacion = new ArrayList<java.lang.String>();
        listaEducacion.add("Universidad Autónoma de Baja California, Facultad de Ingenieria Mexicali");
        listaEducacion.add("Tecnico Electronico del Centro de Bachillerato Tecnologico Industrial y de Servicios No. 21");
        curri.setEducacion(listaEducacion);

        List<java.lang.String> listaConocimiento = new ArrayList<java.lang.String>();
        listaConocimiento.add("C#, Java, HTML, CSS, Bases de Datos Relacionales");
        listaConocimiento.add("Frameworks: RUP y Scrum");
        listaConocimiento.add("Arquitectura JSF");
        curri.setConocimiento(listaConocimiento);

        List<java.lang.String> listaOtros = new ArrayList<java.lang.String>();
        listaOtros.add("Español Nativo");
        listaOtros.add("Ingles Avanzado");
        listaOtros.add("21 años de Edad");
        curri.setOtros(listaOtros);


        model.addAttribute("cv",curri); // cv es el identificador a usar en el HTML
        return "cv";
    }
}
