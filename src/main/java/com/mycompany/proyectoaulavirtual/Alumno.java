package com.mycompany.proyectoaulavirtual;

import java.io.*;

public class Alumno {
    
    private String nombre;
    private String rut;
    private int edad;
    private String curso;
    private String ingresado;
    private BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );

    public Alumno(String nombre, String rut, int edad, String curso) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.curso = curso;
    }
        
    public void mostrarDatos() {
        System.out.println( "Nombre: " + this.nombre );
        System.out.println( "Rut: " + this.rut );
        System.out.println( "Edad: " + this.edad );
        System.out.println("Curso: " + this.curso );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut( String rut ) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso( String curso ) {
        this.curso = curso;
    }

    public String getIngresado() {
        return ingresado;
    }

    public void setIngresado( String ingresado ) {
        this.ingresado = ingresado;
    }

    public BufferedReader getLector() {
        return lector;
    }

    public void setLector( BufferedReader lector ) {
        this.lector = lector;
    }
    
    
    
}
