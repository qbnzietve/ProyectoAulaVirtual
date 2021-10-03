package com.mycompany.proyectoaulavirtual;

import java.io.*;
import java.util.*;

public class Profesor {
    
    private String nombre;
    private String rut;
    private int edad;
    private ArrayList<Asignatura> cursosImpartidos = null;
    private Map<String, Asignatura> mapaCursos = null;
    private Asignatura cursoBuscado;
    
    public Profesor( String nombre, String rut, int edad ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.cursosImpartidos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    public void inscribirCurso( Asignatura a ) {
        this.cursosImpartidos.add( a );
        this.mapaCursos.put( a.getClave(), a );
    }
    
    public int contarCursos() {
        int cont = 0;
        cont = this.cursosImpartidos.size();
        return cont;
    }
    
    public boolean verificarCurso( String clave ) {
        if ( this.mapaCursos.containsKey( clave ) ) {
            return true;
        }
        else
            return false;
    }
    
    public String obtenerNombreCurso( String clave ) {
        this.cursoBuscado = this.mapaCursos.get( clave );
        return this.cursoBuscado.getNombre();
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
    
    public void mostrarDatos( int i, FileWriter fichero) throws IOException {
        int k;
        fichero.write( "  0" + ( i+1 ) + " | NOMBRE: " + this.nombre +"\n");
        fichero.write( "     | RUT: " + this.rut +"\n");
        fichero.write( "     | EDAD: " + this.edad +"\n");
        if ( !this.cursosImpartidos.isEmpty() ) {
            fichero.write( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosImpartidos.size() - 1 ); k++ ) {
                fichero.write( this.cursosImpartidos.get( k ).getClave() + " | ");
            }
            fichero.write( this.cursosImpartidos.get( k ).getClave() +"\n");
        }
        else {
            fichero.write( "     | CURSOS: No hay cursos inscritos.\n" );
        }
        fichero.write( " ------------------------------------------------------------------------\n");
    }
    
    public void mostrarCursos() {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  PROFESOR: " + this.nombre + " (" + this.rut + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosImpartidos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosImpartidos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void mostrarCursos( int rol ) {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosImpartidos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosImpartidos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void reemplazarCurso( String clave, Asignatura a ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                this.mapaCursos.remove( this.cursosImpartidos.get( i ).getClave() );
                this.cursosImpartidos.set( i, a );
                this.mapaCursos.put( a.getClave(), a );
            }
        }
    }
    
    public void eliminarCurso( String clave ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                this.cursosImpartidos.remove( i );
                this.mapaCursos.remove( clave );
            }
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
