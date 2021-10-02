package com.mycompany.proyectoaulavirtual;

public class Profesor {
    
    private String nombre;
    private String rut;
    private int edad;
    private String curso;
    
    public Profesor( String nombre, String rut, int edad, String curso ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.curso = curso;
    }
    
    public void mostrarDatos( int i ) {
        System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.nombre );
        System.out.println( "     | RUT: " + this.rut );
        System.out.println( "     | EDAD: " + this.edad );
        System.out.println( "     | CURSO: " + this.curso );
        System.out.println( " -----------------------------------------------------------------------");
    }
    
    public void mostrarDatos() {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                          PROFESOR ENCONTRADO                          |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  NOMBRE: " + this.nombre );
        System.out.println( "  RUT: " + this.rut );
        System.out.println( "  EDAD: " + this.edad );
        System.out.println( "  CURSO: " + this.curso );
        System.out.println( " -----------------------------------------------------------------------\n");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
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

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
