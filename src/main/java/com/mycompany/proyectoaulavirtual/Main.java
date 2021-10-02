package com.mycompany.proyectoaulavirtual;

import java.io.*;

public class Main {
    
    public static void main( String arg[] ) throws IOException {
        Colegio colegio = new Colegio();     
        Alumno alumno = null;     
        Profesor profesor = null;
        
        int edad, aux = 0, i = 1, k = 1;
        String opcion, ingresado, nombre, rut, curso;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        /*
        // VALORES DE PRUEBA
        alumno = new Alumno( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20, "INF2241-1"); i++; colegio.agregarAlumno( alumno );
        alumno = new Alumno( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20, "INF2241-1"); i++; colegio.agregarAlumno( alumno );
        profesor = new Profesor( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20, "INF2241-1"); k++; colegio.agregarProfesor( profesor );
        profesor = new Profesor( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20, "INF2241-1"); k++; colegio.agregarProfesor( profesor );
        */
        
        while ( aux == 0 ) {
            System.out.println( " -------------------------------------------------------------------" );
            System.out.println( "|  AULA VIRTUAL                                                     |" );
            System.out.println( " -------------------------------------------------------------------" );
            System.out.println( "|  1. REGISTRAR ALUMNO                                              |" );
            System.out.println( "|  2. REGISTRAR PROFESOR                                            |" );
            System.out.println( "|  3. REGISTRAR CURSO                                               |" );
            System.out.println( "|  4. MOSTRAR ALUMNOS                                               |" );
            System.out.println( "|  5. MOSTRAR PROFESORES                                            |" );
            System.out.println( "|  6. MOSTRAR CURSOS                                                |" );
            System.out.println( "|  7. CONSULTAR ALUMNO                                              |" );
            System.out.println( "|  8. CONSULTAR PROFESOR                                            |" );
            System.out.println( "|  9. CONSULTAR CURSO                                               |" );
            System.out.println( "|  0. CERRAR SESIÓN                                                 |" );
            System.out.println( " -------------------------------------------------------------------" );
            
            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
            opcion = lector.readLine();
            
            switch( opcion ) {
                case "1":
                    System.out.println( "\nINGRESE EL NOMBRE DEL ALUMNO " + ( i ) + ": ");
                    nombre = lector.readLine();
                
                    System.out.println( "INGRESE EL RUT DEL ALUMNO " + ( i ) + ": ");
                    rut = lector.readLine();
                
                    System.out.println( "INGRESE LA EDAD DEL ALUMNO " + ( i ) + ": ");
                    ingresado = lector.readLine();
                
                    edad = Integer.parseInt( ingresado );
                    System.out.println( "INGRESE EL CURSO DEL ALUMNO " + ( i ) + ": ");
                    curso = lector.readLine();
                
                    alumno = new Alumno( nombre, rut, edad, curso );
                    colegio.agregarAlumno( alumno );
                    i++;
                    break;
            
                case "2":
                    System.out.println( "\nINGRESE EL NOMBRE DEL PROFESOR " + ( k ) + ": ");
                    nombre = lector.readLine();
                
                    System.out.println( "INGRESE EL RUT DEL PROFESOR " + ( k ) + ": ");
                    rut = lector.readLine();
                
                    System.out.println( "INGRESE LA EDAD DEL PROFESOR " + ( k ) + ": ");
                    ingresado = lector.readLine();
                
                    edad = Integer.parseInt( ingresado );
                    System.out.println( "INGRESE EL CURSO DEL PROFESOR " + ( k ) + ": ");
                    curso = lector.readLine();
                
                    profesor = new Profesor( nombre, rut, edad, curso );
                    colegio.agregarProfesor( profesor );
                    k++;
                    break;
            
                case "3":
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN NO SE ENCUENTRA DISPONIBLE ACTUALMENTE.\n" );
                    break;
            
                case "4":
                    if ( alumno == null ) {
                        System.out.println( "\nERROR AL MOSTRAR ALUMNOS. NO HAY NINGÚN ALUMNO REGISTRADO.\n" );
                    }
                    else {
                        colegio.mostrarAlumnos();
                    }
                    break;
            
                case "5":
                    if ( profesor == null ) {
                        System.out.println( "\nERROR AL MOSTRAR PROFESORES. NO HAY NINGÚN PROFESOR REGISTRADO.\n" );
                    }
                    else {
                        colegio.mostrarProfesores();
                    }
                    break;
            
                case "6":
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN NO SE ENCUENTRA DISPONIBLE ACTUALMENTE.\n" );
                    break;
                    
                case "7":
                    System.out.println( "\nINGRESE EL RUT DEL ALUMNO QUE DESEA CONSULTAR: " );
                    rut = lector.readLine();
                    colegio.consultarAlumno( rut );
                    break;
                    
                case "8":
                    System.out.println( "\nINGRESE EL RUT DEL PROFESOR QUE DESEA CONSULTAR: " );
                    rut = lector.readLine();
                    colegio.consultarProfesor( rut );
                    break;
                   
                case "9":
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN NO SE ENCUENTRA DISPONIBLE ACTUALMENTE.\n" );
                    break;
            
                case "0":
                    System.out.println( "\nSESIÓN CERRADA." );
                    aux = 1;
                    break;
            
                default:
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.\n");
                    break;
            }
        }
    }
    
}
