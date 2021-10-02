package com.mycompany.proyectoaulavirtual;

import java.util.*;     // Se importa la librería de listas

public class Colegio {
    
    private ArrayList<Alumno> listaAlumnos = null;     // Se crea la listaAlumnos
    private ArrayList<Profesor> listaProfesores = null;     // Se crea listaProfesores
    private HashMap mapaAlumnos = null;
    private HashMap mapaProfesores = null;
    private Alumno alumnoBuscado;
    private Profesor profesorBuscado;

    public Colegio() {
        this.listaAlumnos = new ArrayList<>();
        this.listaProfesores = new ArrayList<>();
        this.mapaAlumnos = new HashMap();
        this.mapaProfesores = new HashMap();
    }
    
    public void agregarAlumno( Alumno a ) {
        this.listaAlumnos.add( a );
        this.mapaAlumnos.put( a.getRut(), a );
    }
    
    public void mostrarAlumnos() {
        System.out.println( "\n ------------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE ALUMNOS                            |");
        System.out.println( " ------------------------------------------------------------------------");
        
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            this.listaAlumnos.get( i ).mostrarDatos( i );
        }
        
        System.out.println( "" );
    }
    
    public void agregarProfesor( Profesor a ) {
        this.listaProfesores.add( a );
        this.mapaProfesores.put( a.getRut(), a );
    }
    
    public void mostrarProfesores() {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                          LISTA DE PROFESORES                          |");
        System.out.println( " -----------------------------------------------------------------------");
        
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            this.listaProfesores.get( i ).mostrarDatos( i );
        }
        
        System.out.println( "" );
    }
    
    public void consultarAlumno( String rut ) {
        if ( mapaAlumnos.containsKey( rut ) ) {
            alumnoBuscado = ( Alumno ) mapaAlumnos.get( rut );
            alumnoBuscado.mostrarDatos();
        }
        else {
            System.out.println( "\nERROR AL BUSCAR ALUMNO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO REGISTRADO.\n" );
        }
    }
    
    public void consultarProfesor( String rut ) {
        if ( mapaProfesores.containsKey( rut ) ) {
            profesorBuscado = ( Profesor ) mapaProfesores.get( rut );
            profesorBuscado.mostrarDatos();
        }
        else {
            System.out.println( "\nERROR AL BUSCAR PROFESOR. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR REGISTRADO.\n" );
        }
    }
    
}
