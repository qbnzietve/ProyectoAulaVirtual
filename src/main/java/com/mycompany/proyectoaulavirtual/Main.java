package com.mycompany.proyectoaulavirtual;

import java.io.*;

public class Main {
    
    public static void main( String arg[] ) throws IOException {
        Colegio colegio = new Colegio();
        Alumno alumno = null;     
        Profesor profesor = null;
        Asignatura asignatura = null;
        //Nota nota = null;
        
        int edad = 0, aux = 0, aux2 = 0, i = 1, k = 1;
        String opcion, ingresado, nombre, rut, clave;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        
        /*
        // VALORES DE PRUEBA
        alumno = new Alumno( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20 ); i++; colegio.agregarAlumno( alumno );
        asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirAsignaturaAlumno( "20.522.213-8", asignatura );
        asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirAsignaturaAlumno( "20.522.213-8", asignatura );
        asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirAsignaturaAlumno( "20.522.213-8", asignatura );
        
        alumno = new Alumno( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20 ); i++; colegio.agregarAlumno( alumno );
        asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirAsignaturaAlumno( "20.731.271-1", asignatura );
        asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirAsignaturaAlumno( "20.731.271-1", asignatura );
        asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirAsignaturaAlumno( "20.731.271-1", asignatura );
        
        alumno = new Alumno( "Marcelo Ignacio Azocar Madrid", "20.150.642-9", 21 ); i++; colegio.agregarAlumno( alumno );
        asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirAsignaturaAlumno( "20.150.642-9", asignatura );
        asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirAsignaturaAlumno( "20.150.642-9", asignatura );
        asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirAsignaturaAlumno( "20.150.642-9", asignatura );
        
        profesor = new Profesor( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20 ); k++; colegio.agregarProfesor( profesor );
        asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirAsignaturaProfesor( "20.522.213-8", asignatura );
        
        profesor = new Profesor( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20 ); k++; colegio.agregarProfesor( profesor );
        asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirAsignaturaProfesor( "20.731.271-1", asignatura );
        
        profesor = new Profesor( "Marcelo Ignacio Azocar Madrid", "20.150.642-9", 21 ); k++; colegio.agregarProfesor( profesor );
        asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirAsignaturaProfesor( "20.150.642-9", asignatura );
        //*/
        
        while ( aux == 0 ) {
            System.out.println( "\n --------------------------------------------------------------------" );
            System.out.println( "|                            AULA VIRTUAL                            |" );
            System.out.println( " --------------------------------------------------------------------" );
            System.out.println( "|  1. REGISTRAR ALUMNO                                               |" );
            System.out.println( "|  2. REGISTRAR PROFESOR                                             |" );
            System.out.println( "|  3. INSCRIBIR CURSO ALUMNO                                         |" );
            System.out.println( "|  4. INSCRIBIR CURSO PROFESOR                                       |" );
            System.out.println( "|  5. MOSTRAR ALUMNOS                                                |" );
            System.out.println( "|  6. MOSTRAR PROFESORES                                             |" );
            System.out.println( "|  7. MOSTRAR CURSOS ALUMNO                                          |" );
            System.out.println( "|  8. MOSTRAR CURSOS PROFESOR                                        |" );
            System.out.println( "|  9. CONSULTAR ALUMNO                                               |" );
            System.out.println( "|  10. CONSULTAR PROFESOR                                            |" );
            System.out.println( "|  11. CONSULTAR CURSO                                               |" );
            System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
            System.out.println( " --------------------------------------------------------------------" );
            
            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
            opcion = lector.readLine();
            
            switch( opcion ) {
                case "1":
                    while ( aux2 == 0 ) {
                        System.out.println( "\nINGRESE EL RUT DEL ALUMNO " + ( i ) + ": ");
                        rut = lector.readLine();
                    
                        if ( !colegio.verificarAlumno( rut ) ) {
                            System.out.println( "INGRESE EL NOMBRE DEL ALUMNO " + ( i ) + ": ");
                            nombre = lector.readLine();
                        
                            while ( aux2 == 0 ) {
                                System.out.println( "INGRESE LA EDAD DEL ALUMNO " + ( i ) + ": ");
                                ingresado = lector.readLine();
                                if ( colegio.esNumero( ingresado ) ) {
                                    edad = ( int ) Double.parseDouble( ingresado );
                                    aux2++;
                                }
                                else {
                                    System.out.println( "\nERROR AL REGISTRAR LA EDAD DEL ALUMNO. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE DE NUEVO.\n" );
                                }
                            }
                
                            alumno = new Alumno( nombre, rut, edad );
                            colegio.agregarAlumno( alumno );
                            i++;
                            
                            while ( aux2 == 1 ) {
                                System.out.println( "\n ---------------------------------------------" );
                                System.out.println( "| ¿DESEA REGISTRAR OTRO ALUMNO EN EL SISTEMA? |" );
                                System.out.println( " ---------------------------------------------" );
                                System.out.println( "| 1. SÍ                                       |" );
                                System.out.println( "| 0. NO                                       |" );
                                System.out.println( " ---------------------------------------------" );
                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                ingresado = lector.readLine();
                            
                                switch( ingresado ) {
                                    case "1":
                                        aux2 = 0;
                                        break;
                                    
                                    case "0":
                                        aux2++;
                                        break;
                                    
                                    default:
                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println( "\nERROR AL REGISTRAR ALUMNO. EL RUT INGRESADO YA SE ENCUENTRA ASOCIADO A OTRO ALUMNO." );
                            aux2++;
                            
                            while ( aux2 == 1 ) {
                                System.out.println( "\n ---------------------------------------------" );
                                System.out.println( "| ¿DESEA REGISTRAR OTRO ALUMNO EN EL SISTEMA? |" );
                                System.out.println( " ---------------------------------------------" );
                                System.out.println( "| 1. SÍ                                       |" );
                                System.out.println( "| 0. NO                                       |" );
                                System.out.println( " ---------------------------------------------" );
                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                ingresado = lector.readLine();
                            
                                switch( ingresado ) {
                                    case "1":
                                        aux2 = 0;
                                        break;
                                    
                                    case "0":
                                        aux2++;
                                        break;
                                    
                                    default:
                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                        break;
                                }
                            }
                        }
                    }
                    
                    aux2 = 0;
                    break;
            
                case "2":
                    while ( aux2 == 0 ) {
                        System.out.println( "\nINGRESE EL RUT DEL PROFESOR " + ( k ) + ": ");
                        rut = lector.readLine();
                    
                        if ( !colegio.verificarProfesor( rut ) ) {
                            System.out.println( "INGRESE EL NOMBRE DEL PROFESOR " + ( k ) + ": ");
                            nombre = lector.readLine();
                        
                            while ( aux2 == 0 ) {
                                System.out.println( "INGRESE LA EDAD DEL PROFESOR " + ( k ) + ": ");
                                ingresado = lector.readLine();
                                if ( colegio.esNumero( ingresado ) ) {
                                    edad = ( int ) Double.parseDouble( ingresado );
                                    aux2++;
                                }
                                else {
                                    System.out.println( "\nERROR AL REGISTRAR LA EDAD DEL PROFESOR. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE DE NUEVO.\n" );
                                }
                            }
                
                            profesor = new Profesor( nombre, rut, edad );
                            colegio.agregarProfesor( profesor );
                            k++;
                        
                            while ( aux2 == 1 ) {
                                System.out.println( "\n -----------------------------------------------" );
                                System.out.println( "| ¿DESEA REGISTRAR OTRO PROFESOR EN EL SISTEMA? |" );
                                System.out.println( " -----------------------------------------------" );
                                System.out.println( "| 1. SÍ                                         |" );
                                System.out.println( "| 0. NO                                         |" );
                                System.out.println( " -----------------------------------------------" );
                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                ingresado = lector.readLine();
                            
                                switch( ingresado ) {
                                    case "1":
                                        aux2 = 0;
                                        break;
                                    
                                    case "0":
                                        aux2++;
                                        break;
                                    
                                    default:
                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println( "\nERROR AL REGISTRAR PROFESOR. EL RUT INGRESADO YA SE ENCUENTRA ASOCIADO A OTRO PROFESOR." );
                            aux2++;
                            
                            while ( aux2 == 1 ) {
                                System.out.println( "\n -----------------------------------------------" );
                                System.out.println( "| ¿DESEA REGISTRAR OTRO PROFESOR EN EL SISTEMA? |" );
                                System.out.println( " -----------------------------------------------" );
                                System.out.println( "| 1. SÍ                                         |" );
                                System.out.println( "| 0. NO                                         |" );
                                System.out.println( " -----------------------------------------------" );
                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                ingresado = lector.readLine();
                            
                                switch( ingresado ) {
                                    case "1":
                                        aux2 = 0;
                                        break;
                                    
                                    case "0":
                                        aux2++;
                                        break;
                                    
                                    default:
                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                        break;
                                }
                            }
                        }
                    }
                    
                    aux2 = 0;                
                    break;
                    
                case "3":
                    if ( alumno == null ) {
                        System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. NO HAY NINGÚN ALUMNO REGISTRADO.");
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL ALUMNO AL QUE DESEA INSCRIBIR EN UN CURSO: ");
                        rut = lector.readLine();
                    
                        if ( colegio.verificarAlumno( rut ) ) {
                            while ( aux2 == 0 ) {
                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                clave = lector.readLine();
                                
                                if ( !colegio.verificarAsignaturaAlumno( rut, clave ) ) {
                                    System.out.println( "INGRESE EL NOMBRE DEL CURSO: ");
                                    nombre = lector.readLine();
                        
                                    asignatura = new Asignatura( nombre, clave );
                                    colegio.inscribirAsignaturaAlumno( rut, asignatura );
                                    aux2++;
                            
                                    while ( aux2 == 1 ) {
                                        System.out.println( "\n ----------------------------------------------------" );
                                        System.out.println( "| ¿DESEA INSCRIBIR OTRA ASIGNATURA PARA ESTE ALUMNO? |" );
                                        System.out.println( " ----------------------------------------------------" );
                                        System.out.println( "| 1. SÍ                                              |" );
                                        System.out.println( "| 0. NO                                              |" );
                                        System.out.println( " ----------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                        ingresado = lector.readLine();
                            
                                        switch( ingresado ) {
                                            case "1":
                                                aux2 = 0;
                                                break;
                                    
                                            case "0":
                                                aux2++;
                                                break;
                                    
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                                break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO ALUMNO.");
                                    aux2++;
                                    
                                    while ( aux2 == 1 ) {
                                        System.out.println( "\n ----------------------------------------------------" );
                                        System.out.println( "| ¿DESEA INSCRIBIR OTRA ASIGNATURA PARA ESTE ALUMNO? |" );
                                        System.out.println( " ----------------------------------------------------" );
                                        System.out.println( "| 1. SÍ                                              |" );
                                        System.out.println( "| 0. NO                                              |" );
                                        System.out.println( " ----------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                        ingresado = lector.readLine();
                            
                                        switch( ingresado ) {
                                            case "1":
                                                aux2 = 0;
                                                break;
                                    
                                            case "0":
                                                aux2++;
                                                break;
                                    
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                                break;
                                        }
                                    }
                                }
                            }
                            aux2 = 0;
                        }
                        else {
                            System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO.");
                        }
                    }
                    
                    break;
                    
                case "4":
                    if ( profesor == null ) {
                        System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. NO HAY NINGÚN PROFESOR REGISTRADO.");
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL PROFESOR AL QUE DESEA INSCRIBIR EN UN CURSO: ");
                        rut = lector.readLine();
                    
                        if ( colegio.verificarProfesor( rut ) ) {
                            while ( aux2 == 0 ) {
                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                clave = lector.readLine();
                        
                                if ( !colegio.verificarAsignaturaProfesor( rut, clave ) ) {
                                    System.out.println( "INGRESE EL NOMBRE DEL CURSO: ");
                                    nombre = lector.readLine();
                        
                                    asignatura = new Asignatura( nombre, clave );
                                    colegio.inscribirAsignaturaProfesor( rut, asignatura );
                                    aux2++;
                            
                                    while ( aux2 == 1 ) {
                                        System.out.println( "\n ------------------------------------------------------" );
                                        System.out.println( "| ¿DESEA INSCRIBIR OTRA ASIGNATURA PARA ESTE PROFESOR? |" );
                                        System.out.println( " ------------------------------------------------------" );
                                        System.out.println( "| 1. SÍ                                                |" );
                                        System.out.println( "| 0. NO                                                |" );
                                        System.out.println( " ------------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                        ingresado = lector.readLine();
                            
                                        switch( ingresado ) {
                                            case "1":
                                                aux2 = 0;
                                                break;
                                    
                                            case "0":
                                                aux2++;
                                                break;
                                    
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                                break;
                                        }
                                    }
                                }
                                else {
                                    System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO PROFESOR.");
                                    aux2++;
                                    
                                    while ( aux2 == 1 ) {
                                        System.out.println( "\n ------------------------------------------------------" );
                                        System.out.println( "| ¿DESEA INSCRIBIR OTRA ASIGNATURA PARA ESTE PROFESOR? |" );
                                        System.out.println( " ------------------------------------------------------" );
                                        System.out.println( "| 1. SÍ                                                |" );
                                        System.out.println( "| 0. NO                                                |" );
                                        System.out.println( " ------------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                        ingresado = lector.readLine();
                            
                                        switch( ingresado ) {
                                            case "1":
                                                aux2 = 0;
                                                break;
                                    
                                            case "0":
                                                aux2++;
                                                break;
                                    
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                                break;
                                        }
                                    }
                                }
                            }
                            aux2 = 0;
                        }
                        else {
                            System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR.");
                        }
                    }
                    
                    break;
            
                case "5":
                    if ( alumno == null ) {
                        System.out.println( "\nERROR AL MOSTRAR ALUMNOS. NO HAY NINGÚN ALUMNO REGISTRADO." );
                    }
                    else {
                        colegio.mostrarAlumnos();
                    }
                    break;
            
                case "6":
                    if ( profesor == null ) {
                        System.out.println( "\nERROR AL MOSTRAR PROFESORES. NO HAY NINGÚN PROFESOR REGISTRADO." );
                    }
                    else {
                        colegio.mostrarProfesores();
                    }
                    break;
            
                case "7":
                    if ( alumno == null ) {
                        System.out.println( "\nERROR AL MOSTRAR CURSOS DEL ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO." );
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL ALUMNO CUYOS CURSOS DESEA MOSTRAR: " );
                        rut = lector.readLine();
                        colegio.mostrarCursosAlumno( rut );
                    }
                    break;
                    
                case "8":
                    if ( profesor == null ) {
                        System.out.println( "\nERROR AL MOSTRAR CURSOS DEL PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO." );
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL PROFESOR CUYOS CURSOS DESEA MOSTRAR: " );
                        rut = lector.readLine();
                        colegio.mostrarCursosProfesor( rut );
                    }
                    break;
                    
                case "9":
                    if ( alumno == null ) {
                        System.out.println( "\nERROR AL CONSULTAR ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO." );
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL ALUMNO QUE DESEA CONSULTAR: " );
                        rut = lector.readLine();
                        colegio.consultarAlumno( rut );
                    }
                    break;
                    
                case "10":
                    if ( profesor == null ) {
                        System.out.println( "\nERROR AL CONSULTAR PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO." );
                    }
                    else {
                        System.out.println( "\nINGRESE EL RUT DEL PROFESOR QUE DESEA CONSULTAR: " );
                        rut = lector.readLine();
                        colegio.consultarProfesor( rut );
                    }
                    break;
                   
                case "11":
                    if ( asignatura == null ) {
                        System.out.println( "\nERROR AL CONSULTAR CURSO. NO HAY NINGÚN CURSO REGISTRADO." );
                    }
                    else {
                        System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA CONSULTAR: " );
                        clave = lector.readLine();
                        colegio.consultarCurso( clave );
                    }
                    break;
            
                case "0":
                    System.out.println( "\nSESIÓN CERRADA." );
                    aux = 1;
                    break;
            
                default:
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                    break;
            }
        }
    }
    
}
