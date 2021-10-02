package com.mycompany.proyectoaulavirtual;

import java.util.*;

public class Profesor {
    
    private String nombre;
    private String rut;
    private int edad;
    //private String curso;
    private ArrayList<Asignatura> cursosImpartidos = null;
    private Map<String, Asignatura> mapaCursos = null;
    
    public Profesor( String nombre, String rut, int edad ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.cursosImpartidos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    public void inscribirAsignatura( Asignatura a ) {
        this.cursosImpartidos.add( a );
        this.mapaCursos.put( a.getClave(), a );
    }
    
    public boolean verificarAsignatura( String clave ) {
        if ( this.mapaCursos.containsKey( clave ) ) {
            return true;
        }
        else
            return false;
    }
    
    public void mostrarDatos( int i ) {
        int k;
        System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.nombre );
        System.out.println( "     | RUT: " + this.rut );
        System.out.println( "     | EDAD: " + this.edad );
        if ( !this.cursosImpartidos.isEmpty() ) {
            System.out.print( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosImpartidos.size() - 1 ); k++) {
                System.out.print( this.cursosImpartidos.get( k ).getClave() + " | ");
            }
            System.out.println( this.cursosImpartidos.get( k ).getClave() );
        }
        else {
            System.out.println( "     | CURSOS: No hay cursos inscritos." );
        }
        System.out.println( " -----------------------------------------------------------------------");
    }
    
    public void mostrarDatos() {
        int i;
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                          PROFESOR ENCONTRADO                          |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  NOMBRE: " + this.nombre );
        System.out.println( "  RUT: " + this.rut );
        System.out.println( "  EDAD: " + this.edad );
        if ( !this.cursosImpartidos.isEmpty() ) {
            System.out.print( "  CURSOS: " );
            for ( i = 0; i < ( this.cursosImpartidos.size() - 1 ); i++) {
                System.out.print( this.cursosImpartidos.get( i ).getClave() + " | ");
            }
            System.out.println( this.cursosImpartidos.get( i ).getClave() );
        }
        else {
            System.out.println( "  CURSOS: No hay cursos inscritos." );
        }
        System.out.println( " -----------------------------------------------------------------------");
    }
    
    public void mostrarCursos() {
        int i;
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  PROFESOR: " + this.nombre + " (" + this.rut + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( i = 0; i < this.cursosImpartidos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosImpartidos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosImpartidos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void mostrarDatosAsignatura( String clave ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                System.out.println( this.cursosImpartidos.get( i ).getNombre() + " (" + this.cursosImpartidos.get( i ).getClave() + ")" );
            }
        }
    }
    
    public void mostrarProfesorAsignatura( int k ) {
        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + this.nombre );
        System.out.println( "     | RUT: " + this.rut );
        System.out.println( "     | EDAD: " + this.edad );
        System.out.println( " ------------------------------------------------------------------------");
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
    /*
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    */
}
