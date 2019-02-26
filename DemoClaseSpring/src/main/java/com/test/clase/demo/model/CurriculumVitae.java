package com.test.clase.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class CurriculumVitae {

    private String foto;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String grado;
    private List<String> contacto;
    private List<String> educacion;
    private List<String> conocimiento;
    private List<String> otros;


}
