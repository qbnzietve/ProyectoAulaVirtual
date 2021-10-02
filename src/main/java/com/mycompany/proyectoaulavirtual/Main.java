package com.mycompany.proyectoaulavirtual;

import java.io.*;

public class Main {
    
    public static void main( String arg[] ) throws IOException {
        Colegio colegio = new Colegio(); // Se construye el objeto colegio que contiene la listaAlumnos
        Alumno alumno = new Alumno( "Bastián", "20.522.213-8", 20, "INF2241-1"); // Se construye el objeto alumno y se registra nombre, rut, edad, curso
        colegio.agregarAlumno( alumno ); // Se guarda el objeto alumno en la listaAlumnos
        colegio.mostrarAlumno(); // Se muestran los alumnos almacenados en listaAlumnos;
        /*
        int opcion, numero, edad, aux = 0, i = 0, k;
        String ingresado, nombre, rut, curso;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        while ( aux == 0 ) {
            System.out.println( " -------------------------------------------------------------------" );
            System.out.println( "|  AULA VIRTUAL                                                     |" );
            System.out.println( " -------------------------------------------------------------------" );
            System.out.println( "|  1. REGISTRAR ALUMNO                                              |" );
            System.out.println( "|  2. REGISTRAR PROFESOR                                            |" );
            System.out.println( "|  3. REGISTRAR ASIGNATURA                                          |" );
            System.out.println( "|  4. CONSULTAR ALUMNO                                              |" );
            System.out.println( "|  5. CONSULTAR PROFESOR                                            |" );
            System.out.println( "|  6. CONSULTAR CURSO                                               |" );
            System.out.println( "|  0. CERRAR SESIÓN                                                 |" );
            System.out.println( " -------------------------------------------------------------------" );
            
            System.out.println( "" );
            System.out.println( "INGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
            ingresado = lector.readLine();
            lector.readLine();
            opcion = Integer.parseInt( ingresado );
            
            if ( opcion == 1 ) {
                System.out.println( "INGRESE LA CANTIDAD DE ALUMNOS QUE DESEA REGISTRAR: ");
                ingresado = lector.readLine();
                lector.readLine();
                numero = Integer.parseInt( ingresado );
                
                for ( k = 0; k < numero; k++ ) {
                    System.out.println( "INGRESE EL NOMBRE DEL ALUMNO " + (k+1) + ": ");
                    nombre = lector.readLine();
                    lector.readLine();
                    System.out.println( "INGRESE EL RUT DEL ALUMNO " + (k+1) + ": ");
                    rut = lector.readLine();
                    lector.readLine();
                    System.out.println( "INGRESE EL NOMBRE DEL ALUMNO " + (k+1) + ": ");
                    nombre = lector.readLine();
                    lector.readLine();
                    edad = Integer.parseInt( ingresado );
                    
                }
            }
            
            if ( opcion == 4 ) {
                System.out.println( "INGRESE EL RUT DEL ALUMNO QUE DESEA CONSULTAR: ");
                ingresado = lector.readLine();
                rut = ingresado;
                
                for ( k = 0; perfil[k].getRut() != rut; k++ ) {
                    if ( rut.areEquals( perfil[k].rut ) )
                }
                
                System.out.println( "ALUMNO " + (k+1) );
                System.out.println( "Nombre: " + perfil[k].getNombre() );
                System.out.println( "RUT: " + perfil[k].getRut() );
                System.out.println( "Edad: " + perfil[k].getEdad() );
                System.out.println( "Curso: " + perfil[k].getCurso() );
            }
            
            if ( opcion == 0 ) {
                System.out.println( "SESIÓN CERRADA." );
                aux = 1;
            }
        }
        */
    }
    
}
