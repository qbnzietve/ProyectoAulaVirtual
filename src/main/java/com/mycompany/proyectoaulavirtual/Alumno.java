package com.mycompany.proyectoaulavirtual;

import java.util.*;

public class Alumno {
    
    private String nombre;
    private String rut;
    private int edad;
    private ArrayList<Asignatura> cursosInscritos = null;
    private Map<String, Asignatura> mapaCursos = null;

    public Alumno() {
    }
    
    public Alumno( String nombre, String rut, int edad ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.cursosInscritos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    public void inscribirAsignatura( Asignatura a ) {
        this.cursosInscritos.add( a );
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
        if ( !this.cursosInscritos.isEmpty() ) {
            System.out.print( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosInscritos.size() - 1 ); k++ ) {
                System.out.print( this.cursosInscritos.get( k ).getClave() + " | ");
            }
            System.out.println( this.cursosInscritos.get( k ).getClave() );
        }
        else {
            System.out.println( "     | CURSOS: No hay cursos inscritos." );
        }
        System.out.println( " ------------------------------------------------------------------------");
    }
    
    public void mostrarDatos() {
        int i;
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                           ALUMNO ENCONTRADO                           |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  NOMBRE: " + this.nombre );
        System.out.println( "  RUT: " + this.rut );
        System.out.println( "  EDAD: " + this.edad );
        if ( !this.cursosInscritos.isEmpty() ) {
            System.out.print( "  CURSOS: " );
            for ( i = 0; i < ( this.cursosInscritos.size() - 1 ); i++ ) {
                System.out.print( this.cursosInscritos.get( i ).getClave() + " | ");
            }
            System.out.println( this.cursosInscritos.get( i ).getClave() );
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
        System.out.println( "  ALUMNO: " + this.nombre + " (" + this.rut + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( i = 0; i < this.cursosInscritos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosInscritos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosInscritos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void mostrarDatosAsignatura( String clave ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                System.out.println( this.cursosInscritos.get( i ).getNombre() + " (" + this.cursosInscritos.get( i ).getClave() + ")" );
            }
        }
    }
    
    public void mostrarAlumnoAsignatura( int k ) {
        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + this.nombre );
        System.out.println( "     | RUT: " + this.rut );
        System.out.println( "     | EDAD: " + this.edad );
        System.out.println( " ------------------------------------------------------------------------");
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
    
}
