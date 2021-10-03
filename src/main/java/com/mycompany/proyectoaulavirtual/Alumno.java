package com.mycompany.proyectoaulavirtual;

import java.io.*;
import java.util.*;

public class Alumno {
    
    private String nombre;
    private String rut;
    private int edad;
    private Apoderado apoderado = null;
    private ArrayList<Asignatura> cursosInscritos = null;
    private Map<String, Asignatura> mapaCursos = null;
    private Asignatura cursoBuscado;

    public Alumno() {
    }
    
    public Alumno( String nombre, String rut, int edad ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.cursosInscritos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    public void registrarApoderado( Apoderado a ) {
        this.apoderado = a;
    }
    
    public boolean verificarApoderado() {
        if ( this.apoderado != null ) {
            return true;
        }
        return false;
    }
    
    public void inscribirCurso( Asignatura a ) {
        this.cursosInscritos.add( a );
        this.mapaCursos.put( a.getClave(), a );
    }
    
    public int contarCursos() {
        int cont = 0;
        cont = this.cursosInscritos.size();
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
    
    public void mostrarDatos( int i, FileWriter fichero ) throws IOException {
        int k;
        fichero.write( "  0" + ( i+1 ) + " | NOMBRE: " + this.nombre +"\n");
        fichero.write( "     | RUT: " + this.rut +"\n");
        fichero.write( "     | EDAD: " + this.edad +"\n");
        if ( !this.cursosInscritos.isEmpty() ) {
            fichero.write( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosInscritos.size() - 1 ); k++ ) {
                fichero.write( this.cursosInscritos.get( k ).getClave() + " | ");
            }
            fichero.write( this.cursosInscritos.get( k ).getClave() +"\n");
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
        System.out.println( "  ALUMNO: " + this.nombre + " (" + this.rut + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosInscritos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosInscritos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void mostrarCursos( int rol ) {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosInscritos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosInscritos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    public void reemplazarCurso( String clave, Asignatura a ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                this.mapaCursos.remove( this.cursosInscritos.get( i ).getClave() );
                this.cursosInscritos.set( i, a );
                this.mapaCursos.put( a.getClave(), a );
            }
        }
    }
    
    public void eliminarCurso( String clave ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                this.cursosInscritos.remove( i );
                this.mapaCursos.remove( clave );
            }
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
