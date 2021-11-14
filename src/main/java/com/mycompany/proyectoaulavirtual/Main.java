package com.mycompany.proyectoaulavirtual;

import java.io.*;

public class Main {
    
    public static void main( String arg[] ) throws IOException {
        //Menu menu = new Menu();
        Colegio colegio = new Colegio();
        Usuario usuario = null;
        Persona alumno = null; 
        Apoderado apoderado = null;
        Persona profesor = null;
        Asignatura asignatura = null;
        Nota nota = null;
        //Asignatura[] asignatura = new Asignatura[1000];
        
        boolean salir = false, volver = false;
        boolean saltar = true, iterar = true;
        int edad = 0, rol = 0, aux = 0, i;
        double valorNota = 0, valorNota2 = 0;
        String opcion, username, rut, nombre, contraseña, clave, evaluacion, ingresado;
        String direccion;
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        /*
        // ADMINISTRADORES
        usuario = new Usuario( "beiache", "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20, "ProyectoAulaVirtual2021", 5 );
        colegio.registrarUsuario( usuario );
        */
        while ( !salir ) {
            volver = false;
            iterar = true;
            System.out.println( "\n --------------------------------------------------------------------" );
            System.out.println( "|                            AULA VIRTUAL                            |" );
            System.out.println( " --------------------------------------------------------------------" );
            System.out.println( "|  1. INICIAR SESIÓN                                                 |" );
            System.out.println( "|  2. REGISTRARSE                                                    |" );
            System.out.println( "|  3. AYUDA                                                          |" );
            System.out.println( "|  4. MENÚ DE ADMINISTRADOR                                          |" );
            System.out.println( "|  0. SALIR                                                          |" );
            System.out.println( " --------------------------------------------------------------------" );
            
            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
            opcion = lector.readLine();
            
            switch( opcion ) {
                case "1":
                    if ( !colegio.hayUsuarios() ) {
                        System.out.println( "\nINGRESE SU NOMBRE DE USUARIO O RUT: ");
                        username = lector.readLine();
                        if ( colegio.verificarUsuario( username ) ) {
                            i = 3;
                            while ( iterar && i > 0 ) {
                                System.out.println( "\nINGRESE SU CONTRASEÑA: ");
                                contraseña = lector.readLine();
                                if ( colegio.verificarContraseña( username, contraseña ) ) {
                                    rol = colegio.obtenerRolUsuario( username );
                                    switch( rol  ) {
                                        case 1:
                                            System.out.println( "\nSESIÓN INICIADA CON ÉXITO. ¡BIENVENIDO!" );
                                            rut = colegio.obtenerRutUsuario( username );
                                            while ( !volver ) {
                                                System.out.println( "\n --------------------------------------------------------------------" );
                                                System.out.println( "|                            AULA VIRTUAL                            |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                System.out.println( "|  1. MOSTRAR PERFIL                                                 |" );
                                                System.out.println( "|  2. MODIFICAR INFORMACIÓN PERSONAL (NO DISPONIBLE)                 |" );
                                                System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                opcion = lector.readLine();
                                    
                                                switch( opcion ) {
                                                    case "1":
                                                        colegio.mostrarDatosUsuario( rut, rol );
                                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                        opcion = lector.readLine();
                                                        break;
                                                        
                                                    case "2":
                                                        System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                                        break;
                                                    
                                                    case "0":
                                                        System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                                                        volver = true;
                                                        rol = 0;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                        break;
                                                }
                                            }
                                            break;
                                    
                                        case 2:
                                            System.out.println( "\nSESIÓN INICIADA CON ÉXITO. ¡BIENVENIDO!" );
                                            rut = colegio.obtenerRutUsuario( username );
                                            while ( !volver ) {
                                                iterar = true;
                                                System.out.println( "\n --------------------------------------------------------------------" );
                                                System.out.println( "|                            AULA VIRTUAL                            |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                System.out.println( "|  1. MOSTRAR PERFIL                                                 |" );
                                                System.out.println( "|  2. MOSTRAR CURSOS                                                 |" );
                                                System.out.println( "|  3. CONSULTAR CURSO                                                |" );
                                                System.out.println( "|  4. INSCRIBIR CURSO                                                |" );
                                                System.out.println( "|  5. MODIFICAR CURSO                                                |" );
                                                System.out.println( "|  6. MODIFICAR INFORMACIÓN PERSONAL (NO DISPONIBLE)                 |" );
                                                System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                    
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                opcion = lector.readLine();
                                    
                                                switch( opcion ) {
                                                    case "1":
                                                        colegio.mostrarDatosAlumno( rut );
                                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                        opcion = lector.readLine();
                                                        break;
                                                
                                                    case "2":
                                                        if ( colegio.cantidadCursosAlumno( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL MOSTRAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            colegio.mostrarCursos( rut, rol );
                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                            opcion = lector.readLine();
                                                        }
                                                        break;
                                            
                                                    case "3":
                                                        if ( colegio.cantidadCursosAlumno( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL CONSULTAR CURSO. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA CONSULTAR: " );
                                                            clave = lector.readLine();
                                                            if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                                colegio.consultarCurso( clave );
                                                                System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                opcion = lector.readLine();
                                                            } else {
                                                                System.out.println( "\nERROR AL CONSULTAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                            }
                                                        }
                                                        break;
                                                    
                                                    case "4":
                                                        while ( !volver ) {
                                                            iterar = true;
                                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                                            clave = lector.readLine();
                                
                                                            if ( !colegio.verificarCursoAlumno( rut, clave ) ) {
                                                                System.out.println( "\nINGRESE EL NOMBRE DEL CURSO: ");
                                                                nombre = lector.readLine();
                        
                                                                asignatura = new Asignatura( nombre, clave );
                                                                colegio.inscribirCursoAlumno( rut, asignatura );
                            
                                                                while ( iterar ) {
                                                                    System.out.println( "\n ----------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA INSCRIBIR OTRO CURSO?      |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "|  1. SÍ                                 |" );
                                                                    System.out.println( "|  0. NO                                 |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            volver = true;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println( "\nERROR AL INSCRIBIR CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL CUAL FORMAS PARTE.");
                                    
                                                                while ( iterar ) {
                                                                    System.out.println( "\n ----------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA INSCRIBIR OTRO CURSO?      |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "|  1. SÍ                                 |" );
                                                                    System.out.println( "|  0. NO                                 |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            volver = true;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        volver = false;
                                                        break;
                                            
                                                    case "5":
                                                        if ( colegio.cantidadCursosAlumno( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            while ( !volver ) {
                                                                iterar = true;
                                                                System.out.println( "\n -------------------------------------------------------------------" );
                                                                System.out.println( "|          ¿QUÉ OPERACIÓN DESEA REALIZAR SOBRE SUS CURSOS?          |");
                                                                System.out.println( " -------------------------------------------------------------------" );
                                                                System.out.println( "|  1. REEMPLAZAR CURSO                                              |" );
                                                                System.out.println( "|  2. ELIMINAR CURSO                                                |");
                                                                System.out.println( "|  0. VOLVER                                                        |");
                                                                System.out.println( " -------------------------------------------------------------------" );
                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                opcion = lector.readLine();
                                    
                                                                switch( opcion ) {
                                                                    case "1":
                                                                        colegio.mostrarCursosAlumno( rut );
                                                                        System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA REEMPLAZAR: " );
                                                                        clave = lector.readLine();
                                                                        if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                                            System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                                            System.out.println( "\nINGRESE LA CLAVE DEL NUEVO CURSO:" );
                                                                            ingresado = lector.readLine();
                                                                            if ( !colegio.verificarCursoAlumno( rut, ingresado ) ) {
                                                                                System.out.println( "\nINGRESE EL NOMBRE DEL NUEVO CURSO: " );
                                                                                nombre = lector.readLine();
                                                                                asignatura = new Asignatura( nombre, ingresado );
                                                        
                                                                                while ( iterar ) {
                                                                                    System.out.println( "\n ------------------------------------------------------------------------" );
                                                                                    System.out.println( "|            ¿ESTÁ SEGURO DE QUE DESEA REEMPLAZAR ESTE CURSO?            |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "  CURSO ORIGINAL: " + colegio.obtenerNombreCursoAlumno( rut, clave ) + " (" + clave + ")" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "  NUEVO CURSO: " + nombre + " (" + ingresado + ")" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------" );
                                                                                    System.out.println( "|  1. SÍ                                                                 |" );
                                                                                    System.out.println( "|  0. NO                                                                 |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------" );
                                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                                    opcion = lector.readLine();
                                                        
                                                                                    switch( opcion ) {
                                                                                        case "1":
                                                                                            colegio.reemplazarCursoAlumno( rut, clave, asignatura );
                                                                                            System.out.println( "\nEL CURSO HA SIDO REEMPLAZADO CON ÉXITO." );
                                                                                            iterar = false;
                                                                                            break;
                                                                
                                                                                        case "0":
                                                                                            System.out.println( "\nEL CURSO NO HA SIDO REEMPLAZADO." );
                                                                                            iterar = false;
                                                                                            break;
                                                            
                                                                                        default:
                                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                System.out.println( "\nERROR AL REEMPLAZAR CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL CUAL FORMAS PARTE." );
                                                                            }
                                                                        } else {
                                                                            System.out.println( "\nERROR AL REEMPLAZAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                                        }
                                                                        iterar = true;
                                                                        while ( iterar ) {
                                                                            System.out.println( "\n ---------------------------------------------------------" );
                                                                            System.out.println( "|          ¿DESEA SEGUIR MODIFICANDO SUS CURSOS?          |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "|  1. SÍ                                                  |" );
                                                                            System.out.println( "|  0. NO                                                  |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                            opcion = lector.readLine();
                                                    
                                                                            switch( opcion ) {
                                                                                case "1":
                                                                                    if ( colegio.cantidadCursosAlumno( rut ) != 0 ) {
                                                                                        iterar = false;
                                                                                    } else {
                                                                                        System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                                                        volver = true;
                                                                                        iterar = false;
                                                                                    }
                                                                                    break;
                                                                
                                                                                case "0":
                                                                                    volver = true;
                                                                                    iterar = false;
                                                                                    break;
                                                            
                                                                                default:
                                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                            
                                                                    case "2":
                                                                        colegio.mostrarCursosAlumno( rut );
                                                                        System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA ELIMINAR: " );
                                                                        clave = lector.readLine();
                                                                        if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                                            System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                                            while ( iterar ) {
                                                                                System.out.println( "\n ------------------------------------------------------------------------" );
                                                                                System.out.println( "|             ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE CURSO?             |" );
                                                                                System.out.println( " ------------------------------------------------------------------------");
                                                                                System.out.println( "  CURSO: " + colegio.obtenerNombreCursoAlumno( rut, clave ) + " (" + clave + ")" );
                                                                                System.out.println( " ------------------------------------------------------------------------");
                                                                                System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                                                System.out.println( " ------------------------------------------------------------------------" );
                                                                                System.out.println( "|  1. SÍ                                                                 |" );
                                                                                System.out.println( "|  0. NO                                                                 |" );
                                                                                System.out.println( " ------------------------------------------------------------------------" );
                                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                                opcion = lector.readLine();
                                                        
                                                                                switch( opcion ) {
                                                                                    case "1":
                                                                                        colegio.eliminarCursoAlumno( rut, clave );
                                                                                        System.out.println( "\nEL CURSO HA SIDO ELIMINADO CON ÉXITO." );
                                                                                        iterar = false;
                                                                                        break;
                                                                
                                                                                    case "0":
                                                                                        System.out.println( "\nEL CURSO NO HA SIDO ELIMINADO." );
                                                                                        iterar = false;
                                                                                        break;
                                                            
                                                                                    default:
                                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                        break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            System.out.println( "\nERROR AL ELIMINAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                                        }
                                                                        iterar = true;
                                                                        while ( iterar ) {
                                                                            System.out.println( "\n ---------------------------------------------------------" );
                                                                            System.out.println( "|          ¿DESEA SEGUIR MODIFICANDO SUS CURSOS?          |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "|  1. SÍ                                                  |" );
                                                                            System.out.println( "|  0. NO                                                  |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                            opcion = lector.readLine();
                                                    
                                                                            switch( opcion ) {
                                                                                case "1":
                                                                                    if ( colegio.cantidadCursosAlumno( rut ) != 0 ) {
                                                                                        iterar = false;
                                                                                    } else {
                                                                                        System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                                                        volver = true;
                                                                                        iterar = false;
                                                                                    }
                                                                                    break;
                                                                
                                                                                case "0":
                                                                                    volver = true;
                                                                                    iterar = false;
                                                                                    break;
                                                            
                                                                                default:
                                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                        
                                                                    case "0":
                                                                        volver = true;
                                                                        break;
                                        
                                                                    default:
                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                        volver = false;
                                                        break;
                                            
                                                    case "6":
                                                        System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                                        break;
                                            
                                                    case "0":
                                                        System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                                                        volver = true;
                                                        rol = 0;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                        break;
                                                }
                                            }
                                            break;
                                        
                                        case 3:
                                            System.out.println( "\nSESIÓN INICIADA CON ÉXITO. ¡BIENVENIDO!" );
                                            rut = colegio.obtenerRutUsuario( username );
                                            while ( !volver ) {
                                                System.out.println( "\n --------------------------------------------------------------------" );
                                                System.out.println( "|                            AULA VIRTUAL                            |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                System.out.println( "|  1. MOSTRAR PERFIL                                                 |" );
                                                System.out.println( "|  2. INSCRIBIR PUPILO                                               |" );
                                                System.out.println( "|  3. MODIFICAR PUPILO                                               |" );
                                                System.out.println( "|  4. MODIFICAR INFORMACIÓN PERSONAL (NO DISPONIBLE)                 |" );
                                                System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                opcion = lector.readLine();
                                    
                                                switch( opcion ) {
                                                    case "1":
                                                        colegio.mostrarDatosUsuario( rut, rol );
                                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                        opcion = lector.readLine();
                                                        break;
                                                        
                                                    case "2":
                                                        nombre = colegio.obtenerNombreUsuario( username );
                                                        rut = colegio.obtenerRutUsuario( username );
                                                        edad = colegio.obtenerEdadUsuario( username );
                                                        apoderado = new Apoderado( nombre, rut, edad );
                                                        iterar = true;
                                                        while ( iterar ) {
                                                            System.out.println( "\nINGRESE EL RUT DE SU PUPILO: " );
                                                            nombre = lector.readLine();
                                                            if ( colegio.verificarAlumno( nombre ) ) {
                                                                if ( !colegio.verificarApoderadoAlumno( nombre ) ) {
                                                                    colegio.registrarApoderadoAlumno( nombre, apoderado );
                                                                    System.out.println( "\nPUPILO REGISTRADO CON ÉXITO." );
                                                                    System.out.println( "\n -----------------------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA REGISTRAR OTRO ALUMNO A SU NOMBRE?      |" );
                                                                    System.out.println( " -----------------------------------------------------" );
                                                                    System.out.println( "| 1. SÍ                                               |" );
                                                                    System.out.println( "| 0. NO                                               |" );
                                                                    System.out.println( " -----------------------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                } else {
                                                                    System.out.println( "\nERROR AL REGISTRAR PUPILO. EL ALUMNO INGRESADO YA TIENE UN APODERADO ASOCIADO A SU CUENTA." );
                                                                    System.out.println( "\n -----------------------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA REGISTRAR OTRO ALUMNO A SU NOMBRE?      |" );
                                                                    System.out.println( " -----------------------------------------------------" );
                                                                    System.out.println( "| 1. SÍ                                               |" );
                                                                    System.out.println( "| 0. NO                                               |" );
                                                                    System.out.println( " -----------------------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println( "\nERROR AL REGISTRAR PUPILO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO.");
                                                                System.out.println( "\n -----------------------------------------------------" );
                                                                System.out.println( "|      ¿DESEA REGISTRAR OTRO ALUMNO A SU NOMBRE?      |" );
                                                                System.out.println( " -----------------------------------------------------" );
                                                                System.out.println( "| 1. SÍ                                               |" );
                                                                System.out.println( "| 0. NO                                               |" );
                                                                System.out.println( " -----------------------------------------------------" );
                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                opcion = lector.readLine();
                            
                                                                switch( opcion ) {
                                                                    case "1":
                                                                        break;
                                    
                                                                    case "0":
                                                                        iterar = false;
                                                                        break;
                                    
                                                                    default:
                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                        
                                                    case "3":
                                                        System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                                        break;
                                                        
                                                    case "4":
                                                        System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                                        break;
                                                    
                                                    case "0":
                                                        System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                                                        volver = true;
                                                        rol = 0;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                        break;
                                                }
                                            }
                                            break;
                                            
                                        case 4:
                                            System.out.println( "\nSESIÓN INICIADA CON ÉXITO. ¡BIENVENIDO!" );
                                            rut = colegio.obtenerRutUsuario( username );
                                            while ( !volver ) {
                                                iterar = true;
                                                System.out.println( "\n --------------------------------------------------------------------" );
                                                System.out.println( "|                            AULA VIRTUAL                            |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                                System.out.println( "|  1. MOSTRAR PERFIL                                                 |" );
                                                System.out.println( "|  2. MOSTRAR CURSOS                                                 |" );
                                                System.out.println( "|  3. CONSULTAR CURSO                                                |" );
                                                System.out.println( "|  4. INSCRIBIR CURSO                                                |" );
                                                System.out.println( "|  5. MODIFICAR CURSO                                                |" );
                                                System.out.println( "|  6. INGRESAR NOTA ALUMNO                                           |" );
                                                System.out.println( "|  7. MODIFICAR INFORMACIÓN PERSONAL (NO DISPONIBLE)                 |" );
                                                System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
                                                System.out.println( " --------------------------------------------------------------------" );
                                    
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                opcion = lector.readLine();
                                    
                                                switch( opcion ) {
                                                    case "1":
                                                        colegio.mostrarDatosProfesor( rut );
                                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                        opcion = lector.readLine();
                                                        break;
                                                
                                                    case "2":
                                                        if ( colegio.cantidadCursosProfesor( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL MOSTRAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            colegio.mostrarCursos( rut, rol );
                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                            opcion = lector.readLine();
                                                        }
                                                        break;
                                            
                                                    case "3":
                                                        if ( colegio.cantidadCursosProfesor( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL CONSULTAR CURSO. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA CONSULTAR: " );
                                                            clave = lector.readLine();
                                                            if ( colegio.verificarCursoProfesor( rut, clave ) ) {
                                                                colegio.consultarCurso( clave );
                                                                System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA CONTINUAR: " );
                                                                opcion = lector.readLine();
                                                                while ( !volver ) {
                                                                    iterar = true;
                                                                    System.out.println( "\n ----------------------------------------------------------------------" );
                                                                    System.out.println( "|    ¿QUÉ OPERACIÓN DESEA REALIZAR A CONTINUACIÓN SOBRE ESTE CURSO?    |");
                                                                    System.out.println( " ----------------------------------------------------------------------" );
                                                                    System.out.println( "|  1. MOSTRAR ALUMNOS SOBRE EL PROMEDIO                                |" );
                                                                    System.out.println( "|  2. MOSTRAR ALUMNOS BAJO EL PROMEDIO                                 |");
                                                                    System.out.println( "|  3. MOSTRAR ALUMNOS EN EL PROMEDIO                                   |");
                                                                    System.out.println( "|  4. MOSTRAR ALUMNOS CON UN PROMEDIO POR ENCIMA DE UN VALOR DADO      |");
                                                                    System.out.println( "|  5. MOSTRAR ALUMNOS CON UN PROMEDIO POR DEBAJO DE UN VALOR DADO      |");
                                                                    System.out.println( "|  6. MOSTRAR ALUMNOS CON UN PROMEDIO ENTRE UN RANGO DADO              |");
                                                                    System.out.println( "|  7. MOSTRAR ALUMNOS EN SITUACIÓN DE REPITENCIA                       |");
                                                                    System.out.println( "|  8. MOSTRAR ALUMNOS SIN NOTAS REGISTRADAS                            |");
                                                                    System.out.println( "|  0. VOLVER                                                           |");
                                                                    System.out.println( " ----------------------------------------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                    opcion = lector.readLine();
                                
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            colegio.mostrarAlumnosSobrePromedio( clave );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "2":
                                                                            colegio.mostrarAlumnosBajoPromedio( clave );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "3":
                                                                            colegio.mostrarAlumnosEnElPromedio( clave );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "4":
                                                                            while ( iterar ) {
                                                                                System.out.println( "\nINGRESE EL VALOR SOBRE EL CUAL SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                                                                System.out.println( "(ADVERTENCIA: EL VALOR INGRESADO SE DEBE ENCONTRAR ENTRE 1 Y 6.9): " );
                                                                                ingresado = lector.readLine();
                                                                                if ( colegio.esNumero( ingresado ) ) {
                                                                                    valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                                    if ( valorNota > 6.9 ) {
                                                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                    } else {
                                                                                        if ( valorNota < 1 ) {
                                                                                            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                        } else {
                                                                                            iterar = false;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                                                }
                                                                            }
                                                                            colegio.mostrarAlumnosSobreValor( clave, valorNota );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "5":
                                                                            while ( iterar ) {
                                                                                System.out.println( "\nINGRESE EL VALOR BAJO EL CUAL SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                                                                System.out.println( "(ADVERTENCIA: EL VALOR INGRESADO SE DEBE ENCONTRAR ENTRE 1.1 Y 7): " );
                                                                                ingresado = lector.readLine();
                                                                                if ( colegio.esNumero( ingresado ) ) {
                                                                                    valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                                    if ( valorNota > 7 ) {
                                                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                    } else {
                                                                                        if ( valorNota < 1.1 ) {
                                                                                            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                        } else {
                                                                                            iterar = false;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                                                }
                                                                            }
                                                                            colegio.mostrarAlumnosBajoValor( clave, valorNota );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "6":
                                                                            while ( iterar ) {
                                                                                System.out.println( "\nINGRESE LOS VALORES ENTRE LOS CUALES SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                                                                System.out.println( "(ADVERTENCIA: LOS VALORES INGRESADOS SE DEBEN ENCONTRAR ENTRE 1 Y 7, Y NO PUEDEN REPETIRSE): " );
                                                                                System.out.println( "\nVALOR 1: " );
                                                                                ingresado = lector.readLine();
                                                                                if ( colegio.esNumero( ingresado ) ) {
                                                                                    valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                                    if ( valorNota > 7 ) {
                                                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                    } else {
                                                                                        if ( valorNota < 1 ) {
                                                                                            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                        } else {
                                                                                            iterar = false;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                                                }
                                                                            }
                                                                            iterar = true;
                                                                            while ( iterar ) {
                                                                                System.out.println( "\nVALOR 2: " );
                                                                                ingresado = lector.readLine();
                                                                                if ( colegio.esNumero( ingresado ) ) {
                                                                                    valorNota2 = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                                    if ( valorNota2 > 7 ) {
                                                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                    } else {
                                                                                        if ( valorNota2 < 1 ) {
                                                                                            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                        } else {
                                                                                            if ( valorNota == valorNota2 ) {
                                                                                                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ES IGUAL AL VALOR ANTERIOR, INTENTE NUEVAMENTE." );
                                                                                            } else {
                                                                                                iterar = false;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                                                }
                                                                            }
                                                                            colegio.mostrarAlumnosEntreValor( clave, valorNota, valorNota2 );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "7":
                                                                            colegio.mostrarAlumnosRepitentes( clave );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "8":
                                                                            colegio.mostrarAlumnosSinNotas( clave );
                                                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                                            opcion = lector.readLine();
                                                                            break;
                                        
                                                                        case "0":
                                                                            volver = true;
                                                                            break;
                                        
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println( "\nERROR AL CONSULTAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                            }
                                                        }
                                                        volver = false;
                                                        break;
                                                    
                                                    case "4":
                                                        while ( !volver ) {
                                                            iterar = true;
                                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                                            clave = lector.readLine();
                                
                                                            if ( !colegio.verificarCursoProfesor( rut, clave ) ) {
                                                                System.out.println( "\nINGRESE EL NOMBRE DEL CURSO: ");
                                                                nombre = lector.readLine();
                        
                                                                asignatura = new Asignatura( nombre, clave );
                                                                colegio.inscribirCursoProfesor( rut, asignatura );
                            
                                                                while ( iterar ) {
                                                                    System.out.println( "\n ----------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA INSCRIBIR OTRO CURSO?      |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "|  1. SÍ                                 |" );
                                                                    System.out.println( "|  0. NO                                 |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            volver = true;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println( "\nERROR AL INSCRIBIR CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL CUAL FORMAS PARTE.");
                                    
                                                                while ( iterar ) {
                                                                    System.out.println( "\n ----------------------------------------" );
                                                                    System.out.println( "|      ¿DESEA INSCRIBIR OTRO CURSO?      |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "|  1. SÍ                                 |" );
                                                                    System.out.println( "|  0. NO                                 |" );
                                                                    System.out.println( " ----------------------------------------" );
                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                    opcion = lector.readLine();
                            
                                                                    switch( opcion ) {
                                                                        case "1":
                                                                            iterar = false;
                                                                            break;
                                    
                                                                        case "0":
                                                                            iterar = false;
                                                                            volver = true;
                                                                            break;
                                    
                                                                        default:
                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                            break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        volver = false;
                                                        break;
                                            
                                                    case "5":
                                                        if ( colegio.cantidadCursosProfesor( rut ) == 0 ) {
                                                            System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                        } else {
                                                            while ( !volver ) {
                                                                iterar = true;
                                                                System.out.println( "\n -------------------------------------------------------------------" );
                                                                System.out.println( "|          ¿QUÉ OPERACIÓN DESEA REALIZAR SOBRE SUS CURSOS?          |");
                                                                System.out.println( " -------------------------------------------------------------------" );
                                                                System.out.println( "|  1. REEMPLAZAR CURSO                                              |" );
                                                                System.out.println( "|  2. ELIMINAR CURSO                                                |");
                                                                System.out.println( "|  0. VOLVER                                                        |");
                                                                System.out.println( " -------------------------------------------------------------------" );
                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                opcion = lector.readLine();
                                    
                                                                switch( opcion ) {
                                                                    case "1":
                                                                        colegio.mostrarCursosProfesor( rut );
                                                                        System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA REEMPLAZAR: " );
                                                                        clave = lector.readLine();
                                                                        if ( colegio.verificarCursoProfesor( rut, clave ) ) {
                                                                            System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                                            System.out.println( "\nINGRESE LA CLAVE DEL NUEVO CURSO:" );
                                                                            ingresado = lector.readLine();
                                                                            if ( !colegio.verificarCursoProfesor( rut, ingresado ) ) {
                                                                                System.out.println( "\nINGRESE EL NOMBRE DEL NUEVO CURSO: " );
                                                                                nombre = lector.readLine();
                                                                                asignatura = new Asignatura( nombre, ingresado );
                                                        
                                                                                while ( iterar ) {
                                                                                    System.out.println( "\n ------------------------------------------------------------------------" );
                                                                                    System.out.println( "|            ¿ESTÁ SEGURO DE QUE DESEA REEMPLAZAR ESTE CURSO?            |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "  CURSO ORIGINAL: " + colegio.obtenerNombreCursoProfesor( rut, clave ) + " (" + clave + ")" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "  NUEVO CURSO: " + nombre + " (" + ingresado + ")" );
                                                                                    System.out.println( " ------------------------------------------------------------------------");
                                                                                    System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------" );
                                                                                    System.out.println( "|  1. SÍ                                                                 |" );
                                                                                    System.out.println( "|  0. NO                                                                 |" );
                                                                                    System.out.println( " ------------------------------------------------------------------------" );
                                                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                                    opcion = lector.readLine();
                                                        
                                                                                    switch( opcion ) {
                                                                                        case "1":
                                                                                            colegio.reemplazarCursoProfesor( rut, clave, asignatura );
                                                                                            System.out.println( "\nEL CURSO HA SIDO REEMPLAZADO CON ÉXITO." );
                                                                                            iterar = false;
                                                                                            break;
                                                                
                                                                                        case "0":
                                                                                            System.out.println( "\nEL CURSO NO HA SIDO REEMPLAZADO." );
                                                                                            iterar = false;
                                                                                            break;
                                                            
                                                                                        default:
                                                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                System.out.println( "\nERROR AL REEMPLAZAR CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL CUAL FORMAS PARTE." );
                                                                            }
                                                                        } else {
                                                                            System.out.println( "\nERROR AL REEMPLAZAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                                        }
                                                                        iterar = true;
                                                                        while ( iterar ) {
                                                                            System.out.println( "\n ---------------------------------------------------------" );
                                                                            System.out.println( "|          ¿DESEA SEGUIR MODIFICANDO SUS CURSOS?          |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "|  1. SÍ                                                  |" );
                                                                            System.out.println( "|  0. NO                                                  |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                            opcion = lector.readLine();
                                                    
                                                                            switch( opcion ) {
                                                                                case "1":
                                                                                    if ( colegio.cantidadCursosProfesor( rut ) != 0 ) {
                                                                                        iterar = false;
                                                                                    } else {
                                                                                        System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                                                        volver = true;
                                                                                        iterar = false;
                                                                                    }
                                                                                    break;
                                                                
                                                                                case "0":
                                                                                    volver = true;
                                                                                    iterar = false;
                                                                                    break;
                                                            
                                                                                default:
                                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                            
                                                                    case "2":
                                                                        colegio.mostrarCursosProfesor( rut );
                                                                        System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA ELIMINAR: " );
                                                                        clave = lector.readLine();
                                                                        if ( colegio.verificarCursoProfesor( rut, clave ) ) {
                                                                            System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                                            while ( iterar ) {
                                                                                System.out.println( "\n ------------------------------------------------------------------------" );
                                                                                System.out.println( "|             ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE CURSO?             |" );
                                                                                System.out.println( " ------------------------------------------------------------------------");
                                                                                System.out.println( "  CURSO: " + colegio.obtenerNombreCursoProfesor( rut, clave ) + " (" + clave + ")" );
                                                                                System.out.println( " ------------------------------------------------------------------------");
                                                                                System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                                                System.out.println( " ------------------------------------------------------------------------" );
                                                                                System.out.println( "|  1. SÍ                                                                 |" );
                                                                                System.out.println( "|  0. NO                                                                 |" );
                                                                                System.out.println( " ------------------------------------------------------------------------" );
                                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                                                opcion = lector.readLine();
                                                        
                                                                                switch( opcion ) {
                                                                                    case "1":
                                                                                    colegio.eliminarCursoProfesor( rut, clave );
                                                                                    System.out.println( "\nEL CURSO HA SIDO ELIMINADO CON ÉXITO." );
                                                                                    iterar = false;
                                                                                    break;
                                                                
                                                                                case "0":
                                                                                    System.out.println( "\nEL CURSO NO HA SIDO ELIMINADO." );
                                                                                    iterar = false;
                                                                                    break;
                                                            
                                                                                default:
                                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            System.out.println( "\nERROR AL ELIMINAR CURSO. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                                        }
                                                                        iterar = true;
                                                                        while ( iterar ) {
                                                                            System.out.println( "\n ---------------------------------------------------------" );
                                                                            System.out.println( "|          ¿DESEA SEGUIR MODIFICANDO SUS CURSOS?          |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "|  1. SÍ                                                  |" );
                                                                            System.out.println( "|  0. NO                                                  |" );
                                                                            System.out.println( " ---------------------------------------------------------" );
                                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                            opcion = lector.readLine();
                                                    
                                                                            switch( opcion ) {
                                                                                case "1":
                                                                                    if ( colegio.cantidadCursosProfesor( rut ) != 0 ) {
                                                                                        iterar = false;
                                                                                    } else {
                                                                                        System.out.println( "\nERROR AL MODIFICAR CURSOS. NO ESTÁS INSCRITO EN NINGÚN CURSO." );
                                                                                        volver = true;
                                                                                        iterar = false;
                                                                                    }
                                                                                    break;
                                                                
                                                                                case "0":
                                                                                    volver = true;
                                                                                    iterar = false;
                                                                                    break;
                                                            
                                                                                default:
                                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                                    break;
                                                                            }
                                                                        }
                                                                        volver = false;
                                                                        break;
                                        
                                                                    case "0":
                                                                        volver = true;
                                                                        break;
                                        
                                                                    default:
                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                        
                                                    case "6":
                                                        if ( colegio.hayAlumnos() ) {
                                                            System.out.println( "\nERROR AL AGREGAR NOTA. NO HAY NINGÚN ALUMNO REGISTRADO EN EL SISTEMA." );
                                                        } else {
                                                            if ( asignatura == null ) {
                                                                System.out.println( "\nERROR AL AGREGAR NOTA. NO HAY NINGÚN CURSO REGISTRADO EN EL SISTEMA." );
                                                            } else {
                                                                System.out.println( "\nINGRESE EL RUT DEL ALUMNO AL QUE DESEA AGREGAR UNA NOTA: " );
                                                                nombre = lector.readLine();
                                                                if ( colegio.verificarAlumno( nombre ) ) {
                                                                    if ( colegio.cantidadCursosAlumno( nombre ) == 0 ) {
                                                                        System.out.println( "\nERROR AL AGREGAR NOTA. EL ALUMNO INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                                                    } else {
                                                                        while ( !volver ) {
                                                                            colegio.mostrarCursosAlumno( nombre );
                                                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO EN EL CUAL DESEA AGREGAR LA NOTA: " );
                                                                            clave = lector.readLine();
                                                                            if ( colegio.verificarCursoAlumno( nombre, clave ) ) {
                                                                                if ( !colegio.verificarCursoProfesor( rut, clave ) ) {
                                                                                    while ( !volver ) {
                                                                                        iterar = true;
                                                                                        System.out.println( "\nINGRESE EL NOMBRE DE LA EVALUACIÓN: " );
                                                                                        evaluacion = lector.readLine();
                                                                                        if ( !colegio.verificarEvaluacionAlumno( nombre, clave, evaluacion ) ) {
                                                                                            while ( iterar ) {
                                                                                                System.out.println( "\nINGRESE LA NOTA QUE DESEA AGREGAR" );
                                                                                                System.out.println( "(ADVERTENCIA: LA NOTA DEBE TENER UN VALOR ENTRE 1 Y 7):" );
                                                                                                ingresado = lector.readLine();
                                                                                                if ( colegio.esNumero( ingresado ) ) {
                                                                                                    valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                                                    if ( valorNota > 7 ) {
                                                                                                        System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                                    } else {
                                                                                                        if ( valorNota < 1 ) {
                                                                                                            System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                                                        } else {
                                                                                                            iterar = false;
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                                                                }
                                                                                            } 
                                                                                            nota = new Nota( evaluacion, valorNota );
                                                                                            colegio.agregarNotaAlumno( nombre, clave, nota );
                                                                                            System.out.println( "\nLA NOTA FUE AGREGADA CON ÉXITO." );
                                                                                            iterar = true;
                                                                                            while ( iterar ) {
                                                                                                System.out.println( "\n ---------------------------------------------------" );
                                                                                                System.out.println( "|      ¿DESEA AGREGAR OTRA NOTA EN ESTE CURSO?      |" );
                                                                                                System.out.println( " ---------------------------------------------------" );
                                                                                                System.out.println( "|  1. SÍ                                            |" );
                                                                                                System.out.println( "|  0. NO                                            |" );
                                                                                                System.out.println( " ---------------------------------------------------" );
                                                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                                                opcion = lector.readLine();
                                                    
                                                                                                switch( opcion ) {
                                                                                                    case "1":
                                                                                                        iterar = false;
                                                                                                        break;
                                                            
                                                                                                    case "0":
                                                                                                        iterar = false;
                                                                                                        volver = true;
                                                                                                        break;
                                                            
                                                                                                    default:
                                                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                                                        break;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            System.out.println( "\nERROR AL AGREGAR NOTA. EL NOMBRE INGRESADO YA ESTÁ ASOCIADO A OTRA EVALUACIÓN DEL MISMO ALUMNO, INTENTE NUEVAMENTE." );
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    System.out.println( "\nERROR AL AGREGAR NOTA. NO ESTÁS INSCRITO EN EL CURSO INGRESADO." );
                                                                                }
                                                                            } else {
                                                                                System.out.println( "\nERROR AL AGREGAR NOTA. EL ALUMNO NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                                                            }
                                                                            iterar = true;
                                                                            while ( iterar ) {
                                                                                System.out.println( "\n ---------------------------------------------------" );
                                                                                System.out.println( "|  ¿DESEA SEGUIR AGREGANDO NOTAS PARA ESTE ALUMNO?  |" );
                                                                                System.out.println( " ---------------------------------------------------" );
                                                                                System.out.println( "|  1. SÍ                                            |" );
                                                                                System.out.println( "|  0. NO                                            |" );
                                                                                System.out.println( " ---------------------------------------------------" );
                                                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                                                opcion = lector.readLine();
                                                
                                                                                switch( opcion ) {
                                                                                    case "1":
                                                                                        iterar = false;
                                                                                        volver = false;
                                                                                        break;
                                                    
                                                                                    case "0":
                                                                                        iterar = false;
                                                                                        volver = true;
                                                                                        break;
                                                        
                                                                                    default:
                                                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                                        break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    System.out.println( "\nERROR AL AGREGAR NOTA. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO." );
                                                                }
                                                            }
                                                        }
                                                        volver = false;
                                                        break;
                                            
                                                    case "7":
                                                        System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                                        break;
                                            
                                                    case "0":
                                                        System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                                                        volver = true;
                                                        rol = 0;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                        break;
                                                }
                                            }
                                            break;
                                    
                                        case 5:
                                            System.out.println( "\nSESIÓN INICIADA CON ÉXITO. ¡BIENVENIDO!" );
                                            rut = colegio.obtenerRutUsuario( username );
                                            while ( !volver ) {
                                                System.out.println( "\n --------------------------------------------" );
                                                System.out.println( "|  ¿DESEA ACCEDER AL MENÚ DE ADMINISTRADOR?  |" );
                                                System.out.println( " --------------------------------------------" );
                                                System.out.println( "|  1. SÍ                                     |" );
                                                System.out.println( "|  0. NO                                     |" );
                                                System.out.println( " --------------------------------------------" );
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                opcion = lector.readLine();
                        
                                                switch( opcion ) {
                                                    case "1":
                                                        volver = true;
                                                        saltar = false;
                                                        break;
                                    
                                                    case "0":
                                                        System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                                                        volver = true;
                                                        rol = 0;
                                                        break;
                                    
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                        break;
                                                }
                                            }
                                            break;
                                            
                                        default:
                                            System.out.println( "\nERROR AL INICIAR SESIÓN. NO FUE POSIBLE OBTENER SU INFORMACIÓN DE USUARIO, INTENTE DE NUEVO MÁS TARDE." );
                                            System.out.println( "SI ESTE ERROR PERSISTE, POR FAVOR, CONTACTE A UN ADMINISTRADOR." );
                                            break;
                                    }
                                    iterar = false;
                                } else {
                                    if ( i > 1 ) {
                                        System.out.println( "\nERROR AL INICIAR SESIÓN. LA CONTRASEÑA INGRESADA NO ES CORRECTA, INTENTE NUEVAMENTE." );
                                        System.out.println( "(INTENTOS RESTANTES: " + (i-1) + ")" );
                                        i--;
                                    } else {
                                        System.out.println( "\nERROR AL INICIAR SESIÓN. LÍMITE DE INTENTOS FALLIDOS AL INGRESAR CONTRASEÑA SUPERADOS." );
                                        System.out.println( "\nSI OLVIDÓ SU CONTRASEÑA, PUEDE RECUPERARLA DESDE EL MENÚ PRINCIPAL DIRIGIÉNDOSE A: " );
                                        System.out.println( "->AYUDA->SOBRE 'INICIAR SESIÓN'->OLVIDÉ MI CONTRASEÑA" );
                                        System.out.println( "\nSI ESTE ERROR PERSISTE, POR FAVOR, CONTACTE A UN ADMINISTRADOR." );
                                        i--;
                                    }
                                }   
                            }
                        } else {
                            System.out.println( "\nERROR AL INICIAR SESIÓN. EL USUARIO INGRESADO NO SE ENCUENTRA REGISTRADO EN EL SISTEMA." );
                        }
                    } else {
                        System.out.println( "\nERROR AL INICIAR SESIÓN. NO HAY NINGÚN USUARIO REGISTRADO EN EL SISTEMA." );
                    }
                    break;
                    
                case "2":
                    System.out.println( "\nINGRESE SU RUT: " );
                    rut = lector.readLine();
                    if ( !colegio.verificarRutUsuario( rut ) ) {
                        while ( iterar ) {
                            System.out.println( "\nINGRESE SU NOMBRE DE USUARIO: " );
                            username = lector.readLine();
                            while ( iterar ) {
                                if ( colegio.verificarNombreUsuario( username ) ) {
                                    System.out.println( "\nERROR AL REGISTRAR USUARIO. EL NOMBRE DE USUARIO INGRESADO YA EXISTE, INTENTE CON UNO DIFERENTE." );
                                    System.out.println( "\nINGRESE SU NOMBRE DE USUARIO: " );
                                    username = lector.readLine();
                                } else {
                                    iterar = false;
                                }
                            }
                        
                            System.out.println( "\nINGRESE SU NOMBRE REAL COMPLETO: " );
                            nombre = lector.readLine();
                        
                            iterar = true;
                            while ( iterar ) {
                                System.out.println( "\nINGRESE SU EDAD: " );
                                ingresado = lector.readLine();
                                if ( colegio.esNumero( ingresado ) ) {
                                    edad = ( int ) Double.parseDouble( ingresado );
                                    iterar = false;
                                } else {
                                    System.out.println( "\nERROR AL REGISTRAR EDAD. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                }
                            }
                            
                            System.out.println( "\nINGRESE SU CONTRASEÑA: " );
                            contraseña = lector.readLine();
                            iterar = true;
                            while ( iterar ) {
                                System.out.println( "\nREPITA SU CONTRASEÑA: " );
                                ingresado = lector.readLine();
                                if ( ingresado.equals( contraseña ) ) {
                                    iterar = false;
                                } else {
                                    System.out.println( "\nERROR AL REGISTRAR CONTRASEÑA. LAS CONTRASEÑAS INGRESADAS NO COINCIDEN, INTENTE NUEVAMENTE." );
                                    System.out.println( "\nINGRESE SU CONTRASEÑA: " );
                                    contraseña = lector.readLine();
                                }
                            }
                        
                            iterar = true;
                            while ( iterar ) {
                                System.out.println( "\n -------------------------------------------------------------" );
                                System.out.println( "|                            ROLES                            |" );
                                System.out.println( " -------------------------------------------------------------" );
                                System.out.println( "|  1. ALUMNO                                                  |" );
                                System.out.println( "|  2. APODERADO                                               |" );
                                System.out.println( "|  3. PROFESOR                                                |" );
                                System.out.println( "|  4. ADMINISTRADOR                                           |" );
                                System.out.println( " -------------------------------------------------------------" );
                        
                                System.out.println( "\nINGRESE EL ROL AL QUE DESEA PERTENECER: " );
                                ingresado = lector.readLine();
                            
                                if ( colegio.esNumero( ingresado ) ) {
                                    rol = ( int ) Double.parseDouble( ingresado );
                                    if ( rol >= 1 && rol <= 4 ) {
                                        iterar = false;
                                    } else {
                                        System.out.println( "\nERROR AL ASIGNAR ROL. EL NÚMERO INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ROL, INTENTE NUEVAMENTE." );
                                    }
                                } else {
                                    System.out.println( "\nERROR AL ASIGNAR ROL. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                }
                            }
                        
                            usuario = new Usuario( username, nombre, rut, edad, contraseña, (rol+1) );
                            colegio.registrarUsuario( usuario );
                        
                            switch( rol ) {
                                case 1:
                                    if ( !colegio.verificarAlumno( rut ) ) {
                                        alumno = new Alumno( nombre, rut, edad );
                                        colegio.agregarAlumno( alumno );
                                    }
                                    break;
                            
                                case 3:
                                    if ( !colegio.verificarProfesor( rut ) ) {
                                        profesor = new Profesor( nombre, rut, edad );
                                        colegio.agregarProfesor( profesor );
                                    }
                                    break;
                                
                                default:
                                    break;
                            }
                        
                            System.out.println( "\nNUEVO USUARIO REGISTRADO CON ÉXITO.");
                            rol = 0;
                            iterar = false;
                        }
                    } else {
                        System.out.println( "\nERROR AL REGISTRAR USUARIO. EL RUT INGRESADO YA ESTÁ ASOCIADO A OTRO USUARIO." );
                    }
                    break;
                    
                case "3":
                    while ( !volver ) {
                        iterar = true;
                        System.out.println( "\n ---------------------------------------------------------------------" );
                        System.out.println( "|                              AYUDA (1)                              |" );
                        System.out.println( " ---------------------------------------------------------------------" );
                        System.out.println( "|  1. SOBRE 'INICIAR SESIÓN'                                          |" );
                        System.out.println( "|  2. SOBRE 'REGISTRARSE'                                             |" );
                        System.out.println( "|  3. SOBRE 'MENÚ DE ADMINISTRADOR'                                   |" );
                        System.out.println( "|  4. ACERCA DE ESTA APLICACIÓN                                       |" );
                        System.out.println( "|  0. VOLVER                                                          |" );
                        System.out.println( " ---------------------------------------------------------------------" );
            
                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                        opcion = lector.readLine();
                        
                        switch( opcion ) {
                            case "1":
                                System.out.println( "\n ----------------------------------------------------------------------" );
                                System.out.println( "|                        SOBRE 'INICIAR SESIÓN'                        |" );
                                System.out.println( " ----------------------------------------------------------------------" );
                                System.out.println( "|  A través del menú INICIAR SESIÓN, los usuarios pueden iniciar       |" );
                                System.out.println( "|  sesión en sus cuentas. Existen dos formas de acceder a una misma    |" );
                                System.out.println( "|  cuenta:                                                             |" );
                                System.out.println( "|                                                                      |" );
                                System.out.println( "|  1. Con el nombre de usuario de la cuenta                            |" );
                                System.out.println( "|                                                                      |" );
                                System.out.println( "|  2. Con el rut asociado a la cuenta                                  |" );
                                System.out.println( "|                                                                      |" );
                                System.out.println( "|  Tanto el nombre de usuario como el rut de una cuenta no pueden      |" );
                                System.out.println( "|  repetirse en ninguna otra, por lo que son exclusivos de su dueño.   |" );
                                System.out.println( "|  Para ambos casos es necesario, además, ingresar la contraseña       |" );
                                System.out.println( "|  correspondiente.                                                    |" );
                                System.out.println( "|                                                                      |" );
                                System.out.println( "|  Adicionalmente a lo anterior, cada cuenta queda vinculada a un rol  |" );
                                System.out.println( "|  específico al momento de registrarse en la aplicación, el cual      |" );
                                System.out.println( "|  solo puede ser modificado por un administrador. El rol de una       |" );
                                System.out.println( "|  cuenta define el tipo de usuario que la maneja y le otorga a su     |" );
                                System.out.println( "|  dueño distintos permisos dentro del programa.                       |" );
                                System.out.println( " ----------------------------------------------------------------------" );
                                
                                System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA CONTINUAR: " );
                                opcion = lector.readLine();
                                
                                while ( iterar ) {
                                    System.out.println( "\n ---------------------------------------------------------------------" );
                                    System.out.println( "|                              AYUDA (2)                              |" );
                                    System.out.println( " ---------------------------------------------------------------------" );
                                    System.out.println( "|  1. SOBRE 'TIPOS DE USUARIO'                                        |" );
                                    System.out.println( "|  2. SOBRE 'INFORMACIÓN PERSONAL'                                    |" );
                                    System.out.println( "|  3. OLVIDÉ MI CONTRASEÑA                                            |" );
                                    System.out.println( "|  0. VOLVER                                                          |" );
                                    System.out.println( " ---------------------------------------------------------------------" );
            
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                    opcion = lector.readLine();
                                
                                    switch( opcion ) {
                                        case "1":
                                            System.out.println( "\n ----------------------------------------------------------------------" );
                                            System.out.println( "|                       SOBRE 'TIPOS DE USUARIO'                       |" );
                                            System.out.println( " ----------------------------------------------------------------------" );
                                            System.out.println( "|  Esta aplicación distingue entre distintos tipos de usuario al       |" );
                                            System.out.println( "|  momento de realizar sus operaciones. El tipo de usuario determina   |" );
                                            System.out.println( "|  los permisos que se le atribuyen a una cuenta, limitando las        |" );
                                            System.out.println( "|  acciones que ésta puede realizar en función de su tipo. Existen 5   |" );
                                            System.out.println( "|  tipos de usuario:                                                   |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  1. USUARIO NORMAL: No cuenta con ningún tipo de conexión a la       |" );
                                            System.out.println( "|  organización educativa. Del mismo modo, no cuenta con ningún        |" );
                                            System.out.println( "|  permiso dentro de la aplicación, por lo que sus acciones se ven     |" );
                                            System.out.println( "|  limitadas a ver y modificar su información personal. En principio,  |" );
                                            System.out.println( "|  este tipo de usuario solo existe como un 'placeholder' mientras un  |" );
                                            System.out.println( "|  administrador le otorga un rol diferente a una cuenta nueva.        |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  2. ALUMNO: El tipo de usuario por excelencia. Cuentan con una       |" );
                                            System.out.println( "|  mayor cantidad de permisos que los USUARIOS NORMALES. Entre las     |" );
                                            System.out.println( "|  acciones que pueden realizar se encuentra: ver y modificar su       |" );
                                            System.out.println( "|  información personal, ver los cursos a los que pertenecen y         |" );
                                            System.out.println( "|  consultar por información específica de un curso del cual formen    |" );
                                            System.out.println( "|  parte, así como inscribir cursos nuevos o desinscribir alguno       |" );
                                            System.out.println( "|  antiguo.                                                            |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  3. APODERADO: Un tipo de usuario totalmente dependiente de los      |" );
                                            System.out.println( "|  alumnos a los que representa. Sus únicos permisos consisten en      |" );
                                            System.out.println( "|  administrar su información personal y registrar alumnos a su        |" );
                                            System.out.println( "|  nombre. Un mismo alumno no puede tener más de un apoderado.         |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  4. PROFESOR: Cuenta con los mismos permisos que un usuario de tipo  |" );
                                            System.out.println( "|  ALUMNO.                                                             |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  5. ADMINISTRADOR: El tipo de usuario de mayor jerarquía. Puede ver  |" );
                                            System.out.println( "|  y administrar la información de todos los usuarios registrados en   |" );
                                            System.out.println( "|  el sistema. Se les da acceso al 'menú de administrador', donde se   |" );
                                            System.out.println( "|  les facilita la realización de todas estas tareas.                  |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  En la versión actual de la aplicación, el tipo de usuario que se    |" );
                                            System.out.println( "|  le asigna a una cuenta puede ser seleccionado por el propio         |" );
                                            System.out.println( "|  usuario al momento de crearla.                                      |" );
                                            System.out.println( " ----------------------------------------------------------------------" );
                                            
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                        
                                        case "2":
                                            System.out.println( "\n ----------------------------------------------------------------------" );
                                            System.out.println( "|                     SOBRE 'INFORMACIÓN PERSONAL'                     |" );
                                            System.out.println( " ----------------------------------------------------------------------" );
                                            System.out.println( "|  Al momento de registrarse en el sistema, los usuarios deben         |" );
                                            System.out.println( "|  proporcionar su información personal para completar su registro.    |" );
                                            System.out.println( "|  Entre los datos solicitados se encuentra: su rut, su nombre de      |" );
                                            System.out.println( "|  usuario, su nombre completo, su edad y su contraseña.               |" );
                                            System.out.println( "|                                                                      |" );
                                            System.out.println( "|  Dicha información personal puede ser modificada en el futuro por    |" );
                                            System.out.println( "|  el mismo usuario o por un administrador, en caso de ser necesario.  |" );
                                            System.out.println( "|  Además de las dos entidades mencionadas, nadie puede modificar la   |" );
                                            System.out.println( "|  información personal de un usuario.                                 |" );
                                            System.out.println( " ----------------------------------------------------------------------" );
                                            
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                        
                                        case "3":
                                            System.out.println( "\nINGRESE SU NOMBRE DE USUARIO O RUT: " );
                                            username = lector.readLine();
                                            if ( colegio.verificarUsuario( username ) ) {
                                                System.out.println( "\n¡CUENTA ENCONTRADA! SU CONTRASEÑA ES: " + colegio.recuperarContraseñaUsuario( username ) );
                                                System.out.println( "PROCURE NO PERDERLA ESTA VEZ." );
                                                System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                                opcion = lector.readLine();
                                            } else {
                                                System.out.println( "\nERROR AL RECUPERAR CONTRASEÑA. EL USUARIO INGRESADO NO SE ENCUENTRA REGISTRADO EN EL SISTEMA, INTENTE NUEVAMENTE." );
                                            }
                                            break;
                                        
                                        case "0":
                                            iterar = false;
                                            break;
                                        
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                            break;
                                    }
                                }
                                break;
                                
                            case "2":
                                System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                break;
                                
                            case "3":
                                System.out.println( "\nOPCIÓN NO DISPONIBLE ACTUALMENTE. SU IMPLEMENTACIÓN ESTÁ PREVISTA PARA FUTURAS ACTUALIZACIONES." );
                                break;
                                
                            case "4":
                                System.out.println( "\n ---------------------------------------------------------------------" );
                                System.out.println( "|                      ACERCA DE ESTA APLICACIÓN                      |" );
                                System.out.println( " ---------------------------------------------------------------------" );
                                System.out.println( "|  ¡Bienvenid@ a 'Proyecto Aula Virtual'! Una aplicación que tiene    |" );
                                System.out.println( "|  como objetivo el ayudar en el manejo de datos de una organización  |" );
                                System.out.println( "|  educativa. La aplicación cuenta con múltiples opciones, a través   |" );
                                System.out.println( "|  de las cuales se podrán registrar usuarios de distintos tipos,     |" );
                                System.out.println( "|  cada uno con sus propias funciones dentro de la misma.             |" );
                                System.out.println( "|                                                                     |" );
                                System.out.println( "|  Ante cualquier duda sobre el funcionamiento de cada apartado de    |" );
                                System.out.println( "|  este programa, no dude en consultar el menú de AYUDA disponible    |" );
                                System.out.println( "|  en el menú principal.                                              |" );
                                System.out.println( "|                                                                     |" );
                                System.out.println( "|                                              Versión Actual: 1.0.1  |" );
                                System.out.println( " ---------------------------------------------------------------------" );
            
                                System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                opcion = lector.readLine();
                                break;
                                
                            case "0":
                                volver = true;
                                break;
                                
                            default:
                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                break;
                        }
                    }
                    break;
                    
                case "4":
                    while ( !volver ) {
                        System.out.println( "\n --------------------------------------------" );
                        System.out.println( "|  ¿DESEA ACCEDER AL MENÚ DE ADMINISTRADOR?  |" );
                        System.out.println( " --------------------------------------------" );
                        System.out.println( "|  1. SÍ                                     |" );
                        System.out.println( "|  0. NO                                     |" );
                        System.out.println( " --------------------------------------------" );
                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                        opcion = lector.readLine();
                        
                        switch( opcion ) {
                            case "1":
                                volver = true;
                                saltar = false;
                                break;
                                    
                            case "0":
                                volver = true;
                                break;
                                    
                            default:
                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                break;
                        }
                    }
                    break;
                    
                case "0":
                    while ( !volver ) {
                        System.out.println( "\n -----------------------------------------------------" );
                        System.out.println( "|  ¿ESTÁ SEGURO DE QUE DESEA SALIR DE LA APLICACIÓN?  |" );
                        System.out.println( " -----------------------------------------------------" );
                        System.out.println( "|  1. SÍ                                              |" );
                        System.out.println( "|  0. NO                                              |" );
                        System.out.println( " -----------------------------------------------------" );
                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                        opcion = lector.readLine();
                        
                        switch( opcion ) {
                            case "1":
                                while ( iterar ) {
                                    System.out.println( "\n ----------------------------------------------------------------" );
                                    System.out.println( "|  ¿DESEA CREAR UN ARCHIVO .txt, CON LOS DATOS DE LOS ALUMNOS Y  |" );
                                    System.out.println( "|   PROFESORES REGISTRADOS HASTA EL MOMENTO, EN SU ESCRITORIO?   |" );
                                    System.out.println( " ----------------------------------------------------------------" );
                                    System.out.println( "|  1. SI                                                         |" );
                                    System.out.println( "|  0. NO                                                         |" );
                                    System.out.println( " ----------------------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                    opcion = lector.readLine();
                                    
                                    switch( opcion ) {
                                        case "1":
                                            System.out.println( "\nINGRESE EL NOMBRE DEL USUARIO DE SU COMPUTADORA:" );
                                            ingresado = lector.readLine();
                                            direccion = "C:/Users/" + ingresado + "/Desktop/ListaAlumnosProfesores";
                                            try {
                                                colegio.crearArchivotxt( direccion );
                                                System.out.println( "\n¡ARCHIVO CREADO CON ÉXITO!" );
                                                iterar = false;
                                            } catch( FileNotFoundException e ) {
                                                System.out.println( "\nERROR AL CREAR ARCHIVO. EL NOMBRE DE USUARIO INGRESADO NO SE CORRESPONDE CON EL DE SU COMPUTADORA, INTENTE NUEVAMENTE." );
                                            }
                                            break;
                                        
                                        case "0":
                                            iterar = false;
                                            break;
                                        
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                            break;  
                                    }
                                }
                                System.out.println( "\nAPLICACIÓN CERRADA CON ÉXITO. ¡GRACIAS POR SU VISITA!");
                                volver = true;
                                salir = true;
                                saltar = true;
                                break;
                                    
                            case "0":
                                volver = true;
                                break;
                                    
                            default:
                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                break;
                        }
                    }
                    break;
                    
                default:
                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                    break;
            }
            
            while ( !saltar ) {
                volver = false;
                iterar = true;
                System.out.println( "\n --------------------------------------------------------------------" );
                System.out.println( "|                            AULA VIRTUAL                            |" );
                System.out.println( " --------------------------------------------------------------------" );
                System.out.println( "|  1. DESBLOQUEAR VALORES DE PRUEBA                                  |" );
                System.out.println( "|  2. REGISTRAR ALUMNO                                               |" );
                System.out.println( "|  3. REGISTRAR PROFESOR                                             |" );
                System.out.println( "|  4. INSCRIBIR CURSO ALUMNO                                         |" );
                System.out.println( "|  5. INSCRIBIR CURSO PROFESOR                                       |" );
                System.out.println( "|  6. MOSTRAR ALUMNOS                                                |" );
                System.out.println( "|  7. MOSTRAR PROFESORES                                             |" );
                System.out.println( "|  8. MOSTRAR CURSOS ALUMNO                                          |" );
                System.out.println( "|  9. MOSTRAR CURSOS PROFESOR                                        |" );
                System.out.println( "|  10. CONSULTAR ALUMNO                                              |" );
                System.out.println( "|  11. CONSULTAR PROFESOR                                            |" );
                System.out.println( "|  12. CONSULTAR CURSO                                               |" );
                System.out.println( "|  13. MODIFICAR CURSO ALUMNO                                        |" );
                System.out.println( "|  14. MODIFICAR CURSO PROFESOR                                      |" );
                System.out.println( "|  15. INGRESAR NOTA ALUMNO                                          |" );
                System.out.println( "|  16. REVISAR SITUACIÓN ACADÉMICA                                   |" );
                System.out.println( "|  17. ELIMINAR ALUMNO                                               |" );
                System.out.println( "|  18. ELIMINAR PROFESOR                                             |" );
                if ( rol == 5 ) {
                    System.out.println( "|  0. CERRAR SESIÓN                                                  |" );
                } else {
                    System.out.println( "|  0. VOLVER                                                         |" );
                }
                System.out.println( " --------------------------------------------------------------------" );
            
                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                opcion = lector.readLine();
            
                switch( opcion ) {
                    case "1":
                        if ( aux == 0 ) {
                            if ( !colegio.verificarAlumno( "20.522.213-8" ) ) {
                                alumno = new Alumno( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20 ); colegio.agregarAlumno( alumno );
                                asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirCursoAlumno( "20.522.213-8", asignatura );
                                asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirCursoAlumno( "20.522.213-8", asignatura );
                                asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirCursoAlumno( "20.522.213-8", asignatura );
                                nota = new Nota( "Control 1", 7 ); colegio.agregarNotaAlumno( "20.522.213-8", "INF2241-1", nota); nota = new Nota( "Control 2", 5.5 ); colegio.agregarNotaAlumno( "20.522.213-8", "INF2241-1", nota);
                                nota = new Nota( "Control 1", 7 ); colegio.agregarNotaAlumno( "20.522.213-8", "EST2168-2", nota); nota = new Nota( "Prueba 1", 6.5 ); colegio.agregarNotaAlumno( "20.522.213-8", "EST2168-2", nota);
                                nota = new Nota( "Control 1", 4.5 ); colegio.agregarNotaAlumno( "20.522.213-8", "INF2243-1", nota); nota = new Nota( "Prueba 1", 5.5 ); colegio.agregarNotaAlumno( "20.522.213-8", "INF2243-1", nota);
                                if ( !colegio.verificarUsuario( "20.522.213-8" ) ) {
                                    usuario = new Usuario( "beiache", "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20, "ProyectoAulaVirtual2021", 2 ); colegio.registrarUsuario( usuario );
                                }
                            }    
                            if ( !colegio.verificarAlumno( "20.731.271-1" ) ) {
                                alumno = new Alumno( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20 ); colegio.agregarAlumno( alumno );
                                asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirCursoAlumno( "20.731.271-1", asignatura );
                                asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirCursoAlumno( "20.731.271-1", asignatura );
                                asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirCursoAlumno( "20.731.271-1", asignatura );
                                nota = new Nota( "Control 1", 7 ); colegio.agregarNotaAlumno( "20.731.271-1", "INF2241-1", nota); nota = new Nota( "Control 2", 7 ); colegio.agregarNotaAlumno( "20.731.271-1", "INF2241-1", nota);
                                nota = new Nota( "Control 1", 4.5 ); colegio.agregarNotaAlumno( "20.731.271-1", "EST2168-2", nota); nota = new Nota( "Prueba 1", 5 ); colegio.agregarNotaAlumno( "20.731.271-1", "EST2168-2", nota);
                                nota = new Nota( "Control 1", 1 ); colegio.agregarNotaAlumno( "20.731.271-1", "INF2243-1", nota); nota = new Nota( "Prueba 1", 6 ); colegio.agregarNotaAlumno( "20.731.271-1", "INF2243-1", nota);
                                if ( !colegio.verificarUsuario( "20.731.271-1" ) ) {
                                    usuario = new Usuario( "qbnzietve", "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20, "ProyectoAulaVirtual2021", 4 ); colegio.registrarUsuario( usuario );
                                }
                            }
                            if ( !colegio.verificarAlumno( "20.150.642-9" ) ) {
                                alumno = new Alumno( "Marcelo Ignacio Azocar Madrid", "20.150.642-9", 21 ); colegio.agregarAlumno( alumno );
                                asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirCursoAlumno( "20.150.642-9", asignatura );
                                asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirCursoAlumno( "20.150.642-9", asignatura );
                                asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirCursoAlumno( "20.150.642-9", asignatura );
                                nota = new Nota( "Control 1", 7 ); colegio.agregarNotaAlumno( "20.150.642-9", "INF2241-1", nota); nota = new Nota( "Control 2", 1 ); colegio.agregarNotaAlumno( "20.150.642-9", "INF2241-1", nota);
                                nota = new Nota( "Control 1", 1 ); colegio.agregarNotaAlumno( "20.150.642-9", "EST2168-2", nota); nota = new Nota( "Prueba 1", 3 ); colegio.agregarNotaAlumno( "20.150.642-9", "EST2168-2", nota);
                                nota = new Nota( "Control 1", 4 ); colegio.agregarNotaAlumno( "20.150.642-9", "INF2243-1", nota); nota = new Nota( "Prueba 1", 7 ); colegio.agregarNotaAlumno( "20.150.642-9", "INF2243-1", nota);
                                if ( !colegio.verificarUsuario( "20.150.642-9" ) ) {
                                    usuario = new Usuario( "Marce", "Marcelo Ignacio Azocar Madrid", "20.150.642-9", 21, "ProyectoAulaVirtual2021", 3 ); colegio.registrarUsuario( usuario );
                                }
                            }
                            if ( !colegio.verificarProfesor( "20.522.213-8" ) ) {
                                profesor = new Profesor( "Bastián Caleb Sepúlveda Silva", "20.522.213-8", 20 ); colegio.agregarProfesor( profesor );
                                asignatura = new Asignatura( "Programación Orientada a Objetos", "INF2241-1" ); colegio.inscribirCursoProfesor( "20.522.213-8", asignatura );
                            }
                            if ( !colegio.verificarProfesor( "20.731.271-1" ) ) {
                                profesor = new Profesor( "Kevin Nicholas Luksic Lucero", "20.731.271-1", 20 ); colegio.agregarProfesor( profesor );
                                asignatura = new Asignatura( "Fundamentos de Probabilidad", "EST2168-2" ); colegio.inscribirCursoProfesor( "20.731.271-1", asignatura );
                            }
                            if ( !colegio.verificarProfesor( "20.150.642-9" ) ) {
                                profesor = new Profesor( "Marcelo Ignacio Azocar Madrid", "20.150.642-9", 21 ); colegio.agregarProfesor( profesor );
                                asignatura = new Asignatura( "Base de Datos", "INF2243-1" ); colegio.inscribirCursoProfesor( "20.150.642-9", asignatura );
                            }
                            System.out.println( "\nVALORES DE PRUEBA DESBLOQUEADOS CON ÉXITO." );
                            aux++;
                        } else {
                            System.out.println( "\nERROR AL DESBLOQUEAR LOS VALORES DE PRUEBA. LOS VALORES DE PRUEBA YA SE ENCUENTRAN DESBLOQUEADOS." );
                        }
                        break;
                    
                    case "2":
                        i = 1;
                        while ( !volver ) {
                            iterar = true;
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO " + ( i ) + ": ");
                            rut = lector.readLine();
                    
                            if ( !colegio.verificarAlumno( rut ) ) {
                                System.out.println( "\nINGRESE EL NOMBRE DEL ALUMNO " + ( i ) + ": ");
                                nombre = lector.readLine();
                        
                                while ( iterar ) {
                                    System.out.println( "\nINGRESE LA EDAD DEL ALUMNO " + ( i ) + ": ");
                                    ingresado = lector.readLine();
                                    if ( colegio.esNumero( ingresado ) ) {
                                        edad = ( int ) Double.parseDouble( ingresado );
                                        iterar = false;
                                    }
                                    else {
                                        System.out.println( "\nERROR AL REGISTRAR LA EDAD DEL ALUMNO. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE.\n" );
                                    }
                                }
                
                                alumno = new Alumno( nombre, rut, edad );
                                colegio.agregarAlumno( alumno );
                                i++;
                            
                                iterar = true;
                                while ( iterar ) {
                                    System.out.println( "\n -----------------------------------------------" );
                                    System.out.println( "|  ¿DESEA REGISTRAR OTRO ALUMNO EN EL SISTEMA?  |" );
                                    System.out.println( " -----------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                        |" );
                                    System.out.println( "|  0. NO                                        |" );
                                    System.out.println( " -----------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                    opcion = lector.readLine();
                            
                                    switch( opcion ) {
                                        case "1":
                                            iterar = false;
                                            break;
                                    
                                        case "0":
                                            iterar = false;
                                            volver = true;
                                            break;
                                    
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL REGISTRAR ALUMNO. EL RUT INGRESADO YA SE ENCUENTRA ASOCIADO A OTRO ALUMNO." );
                            
                                while ( iterar ) {
                                    System.out.println( "\n -----------------------------------------------" );
                                    System.out.println( "|  ¿DESEA REGISTRAR OTRO ALUMNO EN EL SISTEMA?  |" );
                                    System.out.println( " -----------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                        |" );
                                    System.out.println( "|  0. NO                                        |" );
                                    System.out.println( " -----------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                    opcion = lector.readLine();
                                
                                    switch( opcion ) {
                                        case "1":
                                            iterar = false;
                                            break;
                                    
                                        case "0":
                                            iterar = false;
                                            volver = true;
                                            break;
                                    
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE");
                                            break;
                                    }
                                }
                            }
                        }
                        break;
            
                    case "3":
                        while ( !volver ) {
                            i = 1;
                            iterar = true;
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR " + ( i ) + ": ");
                            rut = lector.readLine();
                    
                            if ( !colegio.verificarProfesor( rut ) ) {
                                System.out.println( "INGRESE EL NOMBRE DEL PROFESOR " + ( i ) + ": ");
                                nombre = lector.readLine();
                        
                                while ( iterar ) {
                                    System.out.println( "INGRESE LA EDAD DEL PROFESOR " + ( i ) + ": ");
                                    ingresado = lector.readLine();
                                    if ( colegio.esNumero( ingresado ) ) {
                                        edad = ( int ) Double.parseDouble( ingresado );
                                        iterar = false;
                                    } else {
                                        System.out.println( "\nERROR AL REGISTRAR LA EDAD DEL PROFESOR. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE.\n" );
                                    }
                                }
                
                                profesor = new Profesor( nombre, rut, edad );
                                colegio.agregarProfesor( profesor );
                                i++;
                                
                                iterar = true;
                                while ( iterar ) {
                                    System.out.println( "\n -------------------------------------------------" );
                                    System.out.println( "|  ¿DESEA REGISTRAR OTRO PROFESOR EN EL SISTEMA?  |" );
                                    System.out.println( " -------------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                          |" );
                                    System.out.println( "|  0. NO                                          |" );
                                    System.out.println( " -------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                    opcion = lector.readLine();
                            
                                    switch( opcion ) {
                                        case "1":
                                            iterar = false;
                                            break;
                                    
                                        case "0":
                                            iterar = false;
                                            volver = true;
                                            break;
                                    
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL REGISTRAR PROFESOR. EL RUT INGRESADO YA SE ENCUENTRA ASOCIADO A OTRO PROFESOR." );
                            
                                while ( iterar ) {
                                    System.out.println( "\n -------------------------------------------------" );
                                    System.out.println( "|  ¿DESEA REGISTRAR OTRO PROFESOR EN EL SISTEMA?  |" );
                                    System.out.println( " -------------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                          |" );
                                    System.out.println( "|  0. NO                                          |" );
                                    System.out.println( " -------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                    opcion = lector.readLine();
                            
                                    switch( opcion ) {
                                        case "1":
                                            iterar = false;
                                            break;
                                    
                                        case "0":
                                            iterar = false;
                                            volver = true;
                                            break;
                                    
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                            break;
                                    }
                                }
                            }
                        }                
                        break;
                    
                    case "4":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. NO HAY NINGÚN ALUMNO REGISTRADO.");
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO AL QUE DESEA INSCRIBIR EN UN CURSO: ");
                            rut = lector.readLine();
                    
                            if ( colegio.verificarAlumno( rut ) ) {
                                while ( !volver ) {
                                    iterar = true;
                                    System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                    clave = lector.readLine();
                                
                                    if ( !colegio.verificarCursoAlumno( rut, clave ) ) {
                                        System.out.println( "INGRESE EL NOMBRE DEL CURSO: ");
                                        nombre = lector.readLine();
                        
                                        asignatura = new Asignatura( nombre, clave );
                                        colegio.inscribirCursoAlumno( rut, asignatura );
                            
                                        while ( iterar ) {
                                            System.out.println( "\n -------------------------------------------------" );
                                            System.out.println( "|  ¿DESEA INSCRIBIR OTRO CURSO PARA ESTE ALUMNO?  |" );
                                            System.out.println( " -------------------------------------------------" );
                                            System.out.println( "|  1. SÍ                                          |" );
                                            System.out.println( "|  0. NO                                          |" );
                                            System.out.println( " -------------------------------------------------" );
                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                            opcion = lector.readLine();
                            
                                            switch( opcion ) {
                                                case "1":
                                                    iterar = false;
                                                    break;
                                    
                                                case "0":
                                                    iterar = false;
                                                    volver = true;
                                                    break;
                                    
                                                default:
                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                    break;
                                            }
                                        }
                                    } else {
                                        System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO ALUMNO.");
                                    
                                        while ( iterar ) {
                                            System.out.println( "\n -------------------------------------------------" );
                                            System.out.println( "|  ¿DESEA INSCRIBIR OTRO CURSO PARA ESTE ALUMNO?  |" );
                                            System.out.println( " -------------------------------------------------" );
                                            System.out.println( "|  1. SÍ                                          |" );
                                            System.out.println( "|  0. NO                                          |" );
                                            System.out.println( " -------------------------------------------------" );
                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                            opcion = lector.readLine();
                            
                                            switch( opcion ) {
                                                case "1":
                                                    iterar = false;
                                                    break;
                                    
                                                case "0":
                                                    iterar = false;
                                                    volver = true;
                                                    break;
                                    
                                                default:
                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                    break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL INSCRIBIR AL ALUMNO EN UN CURSO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO.");
                            }
                        }
                        break;
                    
                    case "5":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. NO HAY NINGÚN PROFESOR REGISTRADO.");
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR AL QUE DESEA INSCRIBIR EN UN CURSO: ");
                            rut = lector.readLine();
                    
                            if ( colegio.verificarProfesor( rut ) ) {
                                while ( !volver ) {
                                    iterar = true;
                                    System.out.println( "\nINGRESE LA CLAVE DEL CURSO: ");
                                    clave = lector.readLine();
                        
                                    if ( !colegio.verificarCursoProfesor( rut, clave ) ) {
                                        System.out.println( "INGRESE EL NOMBRE DEL CURSO: ");
                                        nombre = lector.readLine();
                        
                                        asignatura = new Asignatura( nombre, clave );
                                        colegio.inscribirCursoProfesor( rut, asignatura );
                            
                                        while ( iterar ) {
                                            System.out.println( "\n ---------------------------------------------------" );
                                            System.out.println( "|  ¿DESEA INSCRIBIR OTRO CURSO PARA ESTE PROFESOR?  |" );
                                            System.out.println( " ---------------------------------------------------" );
                                            System.out.println( "|  1. SÍ                                            |" );
                                            System.out.println( "|  0. NO                                            |" );
                                            System.out.println( " ---------------------------------------------------" );
                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                            opcion = lector.readLine();
                            
                                            switch( opcion ) {
                                                case "1":
                                                    iterar = false;
                                                    break;
                                    
                                                case "0":
                                                    iterar = false;
                                                    volver = true;
                                                    break;
                                    
                                                default:
                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA.");
                                                    break;
                                            }
                                        }
                                    } else {
                                        System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO PROFESOR.");
                                    
                                        while ( iterar ) {
                                            System.out.println( "\n ---------------------------------------------------" );
                                            System.out.println( "|  ¿DESEA INSCRIBIR OTRO CURSO PARA ESTE PROFESOR?  |" );
                                            System.out.println( " ---------------------------------------------------" );
                                            System.out.println( "|  1. SÍ                                            |" );
                                            System.out.println( "|  0. NO                                            |" );
                                            System.out.println( " ---------------------------------------------------" );
                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                            opcion = lector.readLine();
                            
                                            switch( opcion ) {
                                                case "1":
                                                    iterar = false;
                                                    break;
                                    
                                                case "0":
                                                    iterar = false;
                                                    volver = true;
                                                    break;
                                    
                                                default:
                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA." );
                                                    break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL INSCRIBIR AL PROFESOR EN UN CURSO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR." );
                            }
                        }
                        break;
            
                    case "6":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL MOSTRAR ALUMNOS. NO HAY NINGÚN ALUMNO REGISTRADO." );
                        } else {
                            colegio.mostrarAlumnos();
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
            
                    case "7":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL MOSTRAR PROFESORES. NO HAY NINGÚN PROFESOR REGISTRADO." );
                        } else {
                            colegio.mostrarProfesores();
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
            
                    case "8":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL MOSTRAR CURSOS DEL ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO CUYOS CURSOS DESEA MOSTRAR: " );
                            rut = lector.readLine();
                            colegio.mostrarCursosAlumno( rut );
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
                    
                    case "9":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL MOSTRAR CURSOS DEL PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR CUYOS CURSOS DESEA MOSTRAR: " );
                            rut = lector.readLine();
                            colegio.mostrarCursosProfesor( rut );
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
                    
                    case "10":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL CONSULTAR ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO QUE DESEA CONSULTAR: " );
                            rut = lector.readLine();
                            colegio.consultarAlumno( rut );
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
                    
                    case "11":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL CONSULTAR PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR QUE DESEA CONSULTAR: " );
                            rut = lector.readLine();
                            colegio.consultarProfesor( rut );
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                            opcion = lector.readLine();
                        }
                        break;
                        
                    case "12":
                        if ( asignatura == null ) {
                            System.out.println( "\nERROR AL CONSULTAR CURSO. NO HAY NINGÚN CURSO REGISTRADO EN EL SISTEMA." );
                        } else {
                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA CONSULTAR: " );
                            clave = lector.readLine();
                            colegio.consultarCurso( clave );
                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA CONTINUAR: " );
                            opcion = lector.readLine();
                            while ( !volver ) {
                                iterar = true;
                                System.out.println( "\n ----------------------------------------------------------------------" );
                                System.out.println( "|    ¿QUÉ OPERACIÓN DESEA REALIZAR A CONTINUACIÓN SOBRE ESTE CURSO?    |");
                                System.out.println( " ----------------------------------------------------------------------" );
                                System.out.println( "|  1. MOSTRAR ALUMNOS SOBRE EL PROMEDIO                                |" );
                                System.out.println( "|  2. MOSTRAR ALUMNOS BAJO EL PROMEDIO                                 |");
                                System.out.println( "|  3. MOSTRAR ALUMNOS EN EL PROMEDIO                                   |");
                                System.out.println( "|  4. MOSTRAR ALUMNOS CON UN PROMEDIO POR ENCIMA DE UN VALOR DADO      |");
                                System.out.println( "|  5. MOSTRAR ALUMNOS CON UN PROMEDIO POR DEBAJO DE UN VALOR DADO      |");
                                System.out.println( "|  6. MOSTRAR ALUMNOS CON UN PROMEDIO ENTRE UN RANGO DADO              |");
                                System.out.println( "|  7. MOSTRAR ALUMNOS EN SITUACIÓN DE REPITENCIA                       |");
                                System.out.println( "|  8. MOSTRAR ALUMNOS SIN NOTAS REGISTRADAS                            |");
                                System.out.println( "|  0. VOLVER                                                           |");
                                System.out.println( " ----------------------------------------------------------------------" );
                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                opcion = lector.readLine();
                                
                                switch( opcion ) {
                                    case "1":
                                        colegio.mostrarAlumnosSobrePromedio( clave );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "2":
                                        colegio.mostrarAlumnosBajoPromedio( clave );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "3":
                                        colegio.mostrarAlumnosEnElPromedio( clave );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "4":
                                        while ( iterar ) {
                                            System.out.println( "\nINGRESE EL VALOR SOBRE EL CUAL SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                            System.out.println( "(ADVERTENCIA: EL VALOR INGRESADO SE DEBE ENCONTRAR ENTRE 1 Y 6.9): " );
                                            ingresado = lector.readLine();
                                            if ( colegio.esNumero( ingresado ) ) {
                                                valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                if ( valorNota > 6.9 ) {
                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                } else {
                                                    if ( valorNota < 1 ) {
                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                    } else {
                                                        iterar = false;
                                                    }
                                                }
                                            } else {
                                                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                            }
                                        }
                                        colegio.mostrarAlumnosSobreValor( clave, valorNota );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "5":
                                        while ( iterar ) {
                                            System.out.println( "\nINGRESE EL VALOR BAJO EL CUAL SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                            System.out.println( "(ADVERTENCIA: EL VALOR INGRESADO SE DEBE ENCONTRAR ENTRE 1.1 Y 7): " );
                                            ingresado = lector.readLine();
                                            if ( colegio.esNumero( ingresado ) ) {
                                                valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                if ( valorNota > 7 ) {
                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                } else {
                                                    if ( valorNota < 1.1 ) {
                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                    } else {
                                                        iterar = false;
                                                    }
                                                }
                                            } else {
                                                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                            }
                                        }
                                        colegio.mostrarAlumnosBajoValor( clave, valorNota );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "6":
                                        while ( iterar ) {
                                            System.out.println( "\nINGRESE LOS VALORES ENTRE LOS CUALES SE DEBEN ENCONTRAR LOS PROMEDIOS" );
                                            System.out.println( "(ADVERTENCIA: LOS VALORES INGRESADOS SE DEBEN ENCONTRAR ENTRE 1 Y 7, Y NO PUEDEN REPETIRSE): " );
                                            System.out.println( "\nVALOR 1: " );
                                            ingresado = lector.readLine();
                                            if ( colegio.esNumero( ingresado ) ) {
                                                valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                if ( valorNota > 7 ) {
                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                } else {
                                                    if ( valorNota < 1 ) {
                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                    } else {
                                                        iterar = false;
                                                    }
                                                }
                                            } else {
                                                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                            }
                                        }
                                        iterar = true;
                                        while ( iterar ) {
                                            System.out.println( "\nVALOR 2: " );
                                            ingresado = lector.readLine();
                                            if ( colegio.esNumero( ingresado ) ) {
                                                valorNota2 = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                if ( valorNota2 > 7 ) {
                                                    System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                } else {
                                                    if ( valorNota2 < 1 ) {
                                                        System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                    } else {
                                                        if ( valorNota == valorNota2 ) {
                                                            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO ES IGUAL AL VALOR ANTERIOR, INTENTE NUEVAMENTE." );
                                                        } else {
                                                            iterar = false;
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                            }
                                        }
                                        colegio.mostrarAlumnosEntreValor( clave, valorNota, valorNota2 );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "7":
                                        colegio.mostrarAlumnosRepitentes( clave );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "8":
                                        colegio.mostrarAlumnosSinNotas( clave );
                                        System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                        opcion = lector.readLine();
                                        break;
                                        
                                    case "0":
                                        volver = true;
                                        break;
                                        
                                    default:
                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                        break;
                                }
                            }
                        }
                        break;
                   
                    case "13":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL MODIFICAR CURSOS DEL ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO EN EL SISTEMA." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO CUYOS CURSOS DESEA MODIFICAR: " );
                            rut = lector.readLine();
                            if ( colegio.verificarAlumno( rut ) ) {
                                if ( colegio.cantidadCursosAlumno( rut ) == 0 ) {
                                    System.out.println( "\nERROR AL MODIFICAR CURSOS DEL ALUMNO. EL ALUMNO INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                } else {
                                    while ( !volver ) {
                                        iterar = true;
                                        System.out.println( "\n ------------------------------------------------------------------" );
                                        System.out.println( "|  ¿QUÉ OPERACIÓN DESEA REALIZAR SOBRE LOS CURSOS DE ESTE ALUMNO?  |");
                                        System.out.println( " ------------------------------------------------------------------" );
                                        System.out.println( "|  1. REEMPLAZAR CURSO                                             |" );
                                        System.out.println( "|  2. ELIMINAR CURSO                                               |");
                                        System.out.println( "|  0. VOLVER                                                       |");
                                        System.out.println( " ------------------------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                        opcion = lector.readLine();
                                    
                                        switch( opcion ) {
                                            case "1":
                                                colegio.mostrarCursosAlumno( rut );
                                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA REEMPLAZAR: " );
                                                clave = lector.readLine();
                                                if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                    System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                    System.out.println( "\nINGRESE LA CLAVE DEL NUEVO CURSO:" );
                                                    ingresado = lector.readLine();
                                                    if ( !colegio.verificarCursoAlumno( rut, ingresado ) ) {
                                                        System.out.println( "\nINGRESE EL NOMBRE DEL NUEVO CURSO: " );
                                                        nombre = lector.readLine();
                                                        asignatura = new Asignatura( nombre, ingresado );
                                                        
                                                        while ( iterar ) {
                                                            System.out.println( "\n ------------------------------------------------------------------------" );
                                                            System.out.println( "|            ¿ESTÁ SEGURO DE QUE DESEA REEMPLAZAR ESTE CURSO?            |" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "  CURSO ORIGINAL: " + colegio.obtenerNombreCursoAlumno( rut, clave ) + " (" + clave + ")" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "  NUEVO CURSO: " + nombre + " (" + ingresado + ")" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                            System.out.println( " ------------------------------------------------------------------------" );
                                                            System.out.println( "|  1. SÍ                                                                 |" );
                                                            System.out.println( "|  0. NO                                                                 |" );
                                                            System.out.println( " ------------------------------------------------------------------------" );
                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                            opcion = lector.readLine();
                                                        
                                                            switch( opcion ) {
                                                                case "1":
                                                                    colegio.reemplazarCursoAlumno( rut, clave, asignatura );
                                                                    System.out.println( "\nEL CURSO HA SIDO REEMPLAZADO CON ÉXITO." );
                                                                    iterar = false;
                                                                    break;
                                                                
                                                                case "0":
                                                                    System.out.println( "\nEL CURSO NO HA SIDO REEMPLAZADO." );
                                                                    iterar = false;
                                                                    break;
                                                            
                                                                default:
                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println( "\nERROR AL REEMPLAZAR CURSO DEL ALUMNO. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO ALUMNO." );
                                                    }
                                                } else {
                                                    System.out.println( "\nERROR AL REEMPLAZAR CURSO DEL ALUMNO. EL ALUMNO NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                                }
                                                iterar = true;
                                                while ( iterar ) {
                                                    System.out.println( "\n --------------------------------------------------------" );
                                                    System.out.println( "|  ¿DESEA SEGUIR MODIFICANDO LOS CURSOS DE ESTE ALUMNO?  |" );
                                                    System.out.println( " --------------------------------------------------------" );
                                                    System.out.println( "|  1. SÍ                                                 |" );
                                                    System.out.println( "|  0. NO                                                 |" );
                                                    System.out.println( " --------------------------------------------------------" );
                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                    opcion = lector.readLine();
                                                    
                                                    switch( opcion ) {
                                                        case "1":
                                                            if ( colegio.cantidadCursosAlumno( rut ) != 0 ) {
                                                                iterar = false;
                                                            } else {
                                                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL ALUMNO. EL ALUMNO INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                                                volver = true;
                                                                iterar = false;
                                                            }
                                                            break;
                                                                
                                                        case "0":
                                                            volver = true;
                                                            iterar = false;
                                                            break;
                                                            
                                                        default:
                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                            break;
                                                    }
                                                }
                                                break;
                                            
                                            case "2":
                                                colegio.mostrarCursosAlumno( rut );
                                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA ELIMINAR: " );
                                                clave = lector.readLine();
                                                if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                    System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                    while ( iterar ) {
                                                        System.out.println( "\n ------------------------------------------------------------------------" );
                                                        System.out.println( "|             ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE CURSO?             |" );
                                                        System.out.println( " ------------------------------------------------------------------------");
                                                        System.out.println( "  CURSO: " + colegio.obtenerNombreCursoAlumno( rut, clave ) + " (" + clave + ")" );
                                                        System.out.println( " ------------------------------------------------------------------------");
                                                        System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                        System.out.println( " ------------------------------------------------------------------------" );
                                                        System.out.println( "|  1. SÍ                                                                 |" );
                                                        System.out.println( "|  0. NO                                                                 |" );
                                                        System.out.println( " ------------------------------------------------------------------------" );
                                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                        opcion = lector.readLine();
                                                        
                                                        switch( opcion ) {
                                                            case "1":
                                                            colegio.eliminarCursoAlumno( rut, clave );
                                                            System.out.println( "\nEL CURSO HA SIDO ELIMINADO CON ÉXITO." );
                                                            iterar = false;
                                                            break;
                                                                
                                                            case "0":
                                                                System.out.println( "\nEL CURSO NO HA SIDO ELIMINADO." );
                                                                iterar = false;
                                                                break;
                                                            
                                                            default:
                                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println( "\nERROR AL ELIMINAR CURSO DEL ALUMNO. EL ALUMNO NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                                }
                                                iterar = true;
                                                while ( iterar ) {
                                                    System.out.println( "\n --------------------------------------------------------" );
                                                    System.out.println( "|  ¿DESEA SEGUIR MODIFICANDO LOS CURSOS DE ESTE ALUMNO?  |" );
                                                    System.out.println( " --------------------------------------------------------" );
                                                    System.out.println( "|  1. SÍ                                                 |" );
                                                    System.out.println( "|  0. NO                                                 |" );
                                                    System.out.println( " --------------------------------------------------------" );
                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                    opcion = lector.readLine();
                                                    
                                                    switch( opcion ) {
                                                        case "1":
                                                            if ( colegio.cantidadCursosAlumno( rut ) != 0 ) {
                                                                iterar = false;
                                                            } else {
                                                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL ALUMNO. EL ALUMNO INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                                                volver = true;
                                                                iterar = false;
                                                            }
                                                            break;
                                                                
                                                        case "0":
                                                            volver = true;
                                                            iterar = false;
                                                            break;
                                                            
                                                        default:
                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                            break;
                                                    }
                                                }
                                                break;
                                        
                                            case "0":
                                                volver = true;
                                                break;
                                        
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                break;
                                        }
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL ALUMNO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO." );
                            }
                        }
                        break;
                    
                    case "14":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL MODIFICAR CURSOS DEL PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO EN EL SISTEMA." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR CUYOS CURSOS DESEA MODIFICAR: " );
                            rut = lector.readLine();
                            if ( colegio.verificarProfesor( rut ) ) {
                                if ( colegio.cantidadCursosProfesor( rut ) == 0 ) {
                                    System.out.println( "\nERROR AL MODIFICAR CURSOS DEL PROFESOR. EL PROFESOR INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                } else {
                                    while ( !volver ) {
                                        iterar = true;
                                        System.out.println( "\n --------------------------------------------------------------------" );
                                        System.out.println( "|  ¿QUÉ OPERACIÓN DESEA REALIZAR SOBRE LOS CURSOS DE ESTE PROFESOR?  |");
                                        System.out.println( " --------------------------------------------------------------------" );
                                        System.out.println( "|  1. REEMPLAZAR CURSO                                               |" );
                                        System.out.println( "|  2. ELIMINAR CURSO                                                 |");
                                        System.out.println( "|  0. VOLVER                                                         |");
                                        System.out.println( " --------------------------------------------------------------------" );
                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                        opcion = lector.readLine();
                                    
                                        switch( opcion ) {
                                            case "1":
                                                colegio.mostrarCursosProfesor( rut );
                                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA REEMPLAZAR: " );
                                                clave = lector.readLine();
                                                if ( colegio.verificarCursoProfesor( rut, clave ) ) {
                                                    System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                    System.out.println( "\nINGRESE LA CLAVE DEL NUEVO CURSO:" );
                                                    ingresado = lector.readLine();
                                                    if ( !colegio.verificarCursoProfesor( rut, ingresado ) ) {
                                                        System.out.println( "\nINGRESE EL NOMBRE DEL NUEVO CURSO: " );
                                                        nombre = lector.readLine();
                                                        asignatura = new Asignatura( nombre, ingresado );
                                                        
                                                        while ( iterar ) {
                                                            System.out.println( "\n ------------------------------------------------------------------------" );
                                                            System.out.println( "|            ¿ESTÁ SEGURO DE QUE DESEA REEMPLAZAR ESTE CURSO?            |" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "  CURSO ORIGINAL: " + colegio.obtenerNombreCursoProfesor( rut, clave ) + " (" + clave + ")" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "  NUEVO CURSO: " + nombre + " (" + ingresado + ")" );
                                                            System.out.println( " ------------------------------------------------------------------------");
                                                            System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                            System.out.println( " ------------------------------------------------------------------------" );
                                                            System.out.println( "|  1. SÍ                                                                 |" );
                                                            System.out.println( "|  0. NO                                                                 |" );
                                                            System.out.println( " ------------------------------------------------------------------------" );
                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                            opcion = lector.readLine();
                                                        
                                                            switch( opcion ) {
                                                                case "1":
                                                                    colegio.reemplazarCursoProfesor( rut, clave, asignatura );
                                                                    System.out.println( "\nEL CURSO HA SIDO REEMPLAZADO CON ÉXITO." );
                                                                    iterar = false;
                                                                    break;
                                                                
                                                                case "0":
                                                                    System.out.println( "\nEL CURSO NO HA SIDO REEMPLAZADO." );
                                                                    iterar = false;
                                                                    break;
                                                            
                                                                default:
                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println( "\nERROR AL REEMPLAZAR CURSO DEL PROFESOR. LA CLAVE INGRESADA YA ESTÁ ASOCIADA A OTRO CURSO DEL MISMO PROFESOR." );
                                                    }
                                                } else {
                                                    System.out.println( "\nERROR AL REEMPLAZAR CURSO DEL PROFESOR. EL PROFESOR NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                                }
                                                iterar = true;
                                                while ( iterar ) {
                                                    System.out.println( "\n ----------------------------------------------------------" );
                                                    System.out.println( "|  ¿DESEA SEGUIR MODIFICANDO LOS CURSOS DE ESTE PROFESOR?  |" );
                                                    System.out.println( " ----------------------------------------------------------" );
                                                    System.out.println( "|  1. SÍ                                                   |" );
                                                    System.out.println( "|  0. NO                                                   |" );
                                                    System.out.println( " ----------------------------------------------------------" );
                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                    opcion = lector.readLine();
                                                    
                                                    switch( opcion ) {
                                                        case "1":
                                                            if ( colegio.cantidadCursosProfesor( rut ) != 0 ) {
                                                                iterar = false;
                                                            } else {
                                                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL PROFESOR. EL PROFESOR INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                                                volver = true;
                                                                iterar = false;
                                                            }
                                                            break;
                                                                
                                                        case "0":
                                                            volver = true;
                                                            iterar = false;
                                                            break;
                                                            
                                                        default:
                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                            break;
                                                    }
                                                }
                                                break;
                                            
                                            case "2":
                                                colegio.mostrarCursosProfesor( rut );
                                                System.out.println( "\nINGRESE LA CLAVE DEL CURSO QUE DESEA ELIMINAR: " );
                                                clave = lector.readLine();
                                                if ( colegio.verificarCursoProfesor( rut, clave ) ) {
                                                    System.out.println( "\n¡CURSO ENCONTRADO CON ÉXITO!" );
                                                    while ( iterar ) {
                                                        System.out.println( "\n ------------------------------------------------------------------------" );
                                                        System.out.println( "|             ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE CURSO?             |" );
                                                        System.out.println( " ------------------------------------------------------------------------");
                                                        System.out.println( "  CURSO: " + colegio.obtenerNombreCursoProfesor( rut, clave ) + " (" + clave + ")" );
                                                        System.out.println( " ------------------------------------------------------------------------");
                                                        System.out.println( "|                         ¿CONFIRMAR  OPERACIÓN?                         |" );
                                                        System.out.println( " ------------------------------------------------------------------------" );
                                                        System.out.println( "|  1. SÍ                                                                 |" );
                                                        System.out.println( "|  0. NO                                                                 |" );
                                                        System.out.println( " ------------------------------------------------------------------------" );
                                                        System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                                        opcion = lector.readLine();
                                                        
                                                        switch( opcion ) {
                                                            case "1":
                                                            colegio.eliminarCursoProfesor( rut, clave );
                                                            System.out.println( "\nEL CURSO HA SIDO ELIMINADO CON ÉXITO." );
                                                            iterar = false;
                                                            break;
                                                                
                                                        case "0":
                                                            System.out.println( "\nEL CURSO NO HA SIDO ELIMINADO." );
                                                            iterar = false;
                                                            break;
                                                            
                                                        default:
                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    System.out.println( "\nERROR AL ELIMINAR CURSO DEL PROFESOR. EL PROFESOR NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                                }
                                                iterar = true;
                                                while ( iterar ) {
                                                    System.out.println( "\n ----------------------------------------------------------" );
                                                    System.out.println( "|  ¿DESEA SEGUIR MODIFICANDO LOS CURSOS DE ESTE PROFESOR?  |" );
                                                    System.out.println( " ----------------------------------------------------------" );
                                                    System.out.println( "|  1. SÍ                                                   |" );
                                                    System.out.println( "|  0. NO                                                   |" );
                                                    System.out.println( " ----------------------------------------------------------" );
                                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                    opcion = lector.readLine();
                                                    
                                                    switch( opcion ) {
                                                        case "1":
                                                            if ( colegio.cantidadCursosProfesor( rut ) != 0 ) {
                                                                iterar = false;
                                                            } else {
                                                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL PROFESOR. EL PROFESOR INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                                                volver = true;
                                                                iterar = false;
                                                            }
                                                            break;
                                                                
                                                        case "0":
                                                            volver = true;
                                                            iterar = false;
                                                            break;
                                                            
                                                        default:
                                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE.");
                                                            break;
                                                    }
                                                }
                                                break;
                                        
                                            case "0":
                                                volver = true;
                                                break;
                                        
                                            default:
                                                System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                break;
                                        }
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL MODIFICAR CURSOS DEL PROFESOR. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR." );
                            }
                        }
                        break;
                        
                    case "15":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL AGREGAR NOTA. NO HAY NINGÚN ALUMNO REGISTRADO EN EL SISTEMA." );
                        } else {
                            if ( asignatura == null ) {
                                System.out.println( "\nERROR AL AGREGAR NOTA. NO HAY NINGÚN CURSO REGISTRADO EN EL SISTEMA." );
                            } else {
                                System.out.println( "\nINGRESE EL RUT DEL ALUMNO AL QUE DESEA AGREGAR UNA NOTA: " );
                                rut = lector.readLine();
                                if ( colegio.verificarAlumno( rut ) ) {
                                    if ( colegio.cantidadCursosAlumno( rut ) == 0 ) {
                                        System.out.println( "\nERROR AL AGREGAR NOTA. EL ALUMNO INGRESADO NO ESTÁ INSCRITO EN NINGÚN CURSO." );
                                    } else {
                                        while ( !volver ) {
                                            colegio.mostrarCursosAlumno( rut );
                                            System.out.println( "\nINGRESE LA CLAVE DEL CURSO EN EL CUAL DESEA AGREGAR LA NOTA: " );
                                            clave = lector.readLine();
                                            if ( colegio.verificarCursoAlumno( rut, clave ) ) {
                                                while ( !volver ) {
                                                    iterar = true;
                                                    System.out.println( "\nINGRESE EL NOMBRE DE LA EVALUACIÓN: " );
                                                    evaluacion = lector.readLine();
                                                    if ( !colegio.verificarEvaluacionAlumno( rut, clave, evaluacion ) ) {
                                                        while ( iterar ) {
                                                            System.out.println( "\nINGRESE LA NOTA QUE DESEA AGREGAR" );
                                                            System.out.println( "(ADVERTENCIA: LA NOTA DEBE TENER UN VALOR ENTRE 1 Y 7):" );
                                                            ingresado = lector.readLine();
                                                            if ( colegio.esNumero( ingresado ) ) {
                                                                valorNota = Math.round( Double.parseDouble( ingresado ) * 10 ) / 10d;
                                                                if ( valorNota > 7 ) {
                                                                    System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO EXCEDE EL MÁXIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                } else {
                                                                    if ( valorNota < 1 ) {
                                                                        System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO ESTÁ POR DEBAJO DEL MÍNIMO ACEPTADO, INTENTE NUEVAMENTE." );
                                                                    } else {
                                                                        iterar = false;
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println( "\nERROR AL AGREGAR NOTA. EL VALOR INGRESADO NO ES VÁLIDO, INTENTE NUEVAMENTE." );
                                                            }
                                                        } 
                                                        nota = new Nota( evaluacion, valorNota );
                                                        colegio.agregarNotaAlumno( rut, clave, nota );
                                                        System.out.println( "\nLA NOTA FUE AGREGADA CON ÉXITO." );
                                                        iterar = true;
                                                        while ( iterar ) {
                                                            System.out.println( "\n ---------------------------------------------------" );
                                                            System.out.println( "|      ¿DESEA AGREGAR OTRA NOTA EN ESTE CURSO?      |" );
                                                            System.out.println( " ---------------------------------------------------" );
                                                            System.out.println( "|  1. SÍ                                            |" );
                                                            System.out.println( "|  0. NO                                            |" );
                                                            System.out.println( " ---------------------------------------------------" );
                                                            System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                            opcion = lector.readLine();
                                                    
                                                            switch( opcion ) {
                                                                case "1":
                                                                    iterar = false;
                                                                    break;
                                                            
                                                                case "0":
                                                                    iterar = false;
                                                                    volver = true;
                                                                    break;
                                                            
                                                                default:
                                                                    System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println( "\nERROR AL AGREGAR NOTA. EL NOMBRE INGRESADO YA ESTÁ ASOCIADO A OTRA EVALUACIÓN DEL MISMO ALUMNO, INTENTE NUEVAMENTE." );
                                                    }
                                                }
                                            } else {
                                                System.out.println( "\nERROR AL AGREGAR NOTA. EL ALUMNO NO ESTÁ INSCRITO EN EL CURSO INGRESADO." );
                                            }
                                            iterar = true;
                                            while ( iterar ) {
                                                System.out.println( "\n ---------------------------------------------------" );
                                                System.out.println( "|  ¿DESEA SEGUIR AGREGANDO NOTAS PARA ESTE ALUMNO?  |" );
                                                System.out.println( " ---------------------------------------------------" );
                                                System.out.println( "|  1. SÍ                                            |" );
                                                System.out.println( "|  0. NO                                            |" );
                                                System.out.println( " ---------------------------------------------------" );
                                                System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: ");
                                                opcion = lector.readLine();
                                                
                                                switch( opcion ) {
                                                    case "1":
                                                        iterar = false;
                                                        volver = false;
                                                        break;
                                                    
                                                    case "0":
                                                        iterar = false;
                                                        volver = true;
                                                        break;
                                                        
                                                    default:
                                                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                                        break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println( "\nERROR AL AGREGAR NOTA. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO." );
                                }
                            }
                        }
                        break;
                        
                    case "16":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY NINGÚN ALUMNO REGISTRADO EN EL SISTEMA." );
                        } else {
                            if ( asignatura == null ) {
                                System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY NINGÚN CURSO REGISTRADO EN EL SISTEMA." );
                            } else {
                                while ( !volver ) {
                                    System.out.println( "\n -------------------------------------------------------------------------" );
                                    System.out.println( "|                 ¿QUÉ SITUACIÓN ACADÉMICA DESEA REVISAR?                 |" );
                                    System.out.println( " -------------------------------------------------------------------------");
                                    System.out.println( "|  1. BUSCAR ALUMNO CON PROMEDIO MÁS ALTO                                 |" );
                                    System.out.println( "|  2. BUSCAR ALUMNO CON PROMEDIO MÁS BAJO                                 |" );
                                    System.out.println( "|  3. ALUMNOS CON PROMEDIO SOBRESALIENTE                                  |" );
                                    System.out.println( "|  4. ALUMNOS EN SITUACIÓN DE REPITENCIA                                  |" );
                                    System.out.println( "|  0. VOLVER                                                              |" );
                                    System.out.println( " -------------------------------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR" );
                                    System.out.println( "(OBSERVACIÓN: ESTAS OPERACIONES TRABAJAN EN BASE A LA TOTALIDAD DE CURSOS Y ALUMNOS): " );
                                    opcion = lector.readLine();
                                    
                                    switch( opcion ) {
                                        case "1":
                                            colegio.mostrarAlumnoPromedioMasAlto();
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                            
                                        case "2":
                                            colegio.mostrarAlumnoPromedioMasBajo();
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                            
                                        case "3":
                                            colegio.totalAlumnosPromedioSobresaliente();
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                            
                                        case "4":
                                            colegio.totalAlumnosEnSituaciónRepitencia();
                                            System.out.println( "\nINGRESE CUALQUIER CARÁCTER PARA REGRESAR: " );
                                            opcion = lector.readLine();
                                            break;
                                            
                                        case "0":
                                            volver = true;
                                            break;
                                            
                                        default:
                                            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                            break;
                                    }  
                                }
                            }
                        }
                        break;
                    
                    case "17":
                        if ( colegio.hayAlumnos() ) {
                            System.out.println( "\nERROR AL ELIMINAR ALUMNO. NO HAY NINGÚN ALUMNO REGISTRADO EN EL SISTEMA." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL ALUMNO QUE DESEA ELIMINAR: " );
                            rut = lector.readLine();
                            if ( colegio.verificarAlumno( rut ) ) {
                                System.out.println( "\n¡ALUMNO ENCONTRADO CON ÉXITO!" );
                                while ( iterar ) {
                                    System.out.println( "\n -------------------------------------------------------------------------" );
                                    System.out.println( "|             ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE ALUMNO?             |" );
                                    System.out.println( " -------------------------------------------------------------------------");
                                    System.out.println( "  ALUMNO: " + colegio.obtenerNombreAlumno( rut ) + " (" + rut + ")" );
                                    System.out.println( " -------------------------------------------------------------------------");
                                    System.out.println( "|                          ¿CONFIRMAR OPERACIÓN?                          |" );
                                    System.out.println( " -------------------------------------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                                                  |" );
                                    System.out.println( "|  0. NO                                                                  |" );
                                    System.out.println( " -------------------------------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                    opcion = lector.readLine();
                                    
                                    switch( opcion ) {
                                        case "1":
                                            colegio.eliminarAlumno( rut );
                                            System.out.println( "\nEL ALUMNO HA SIDO ELIMINADO CON ÉXITO." );
                                            iterar = false;
                                            break;
                                                                
                                        case "0":
                                            System.out.println( "\nEL ALUMNO NO HA SIDO ELIMINADO." );
                                            iterar = false;
                                            break;
                                                            
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                            break;
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL ELIMINAR ALUMNO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO." );
                            }
                        }
                        break;
                    
                    case "18":
                        if ( colegio.hayProfesores() ) {
                            System.out.println( "\nERROR AL ELIMINAR PROFESOR. NO HAY NINGÚN PROFESOR REGISTRADO EN EL SISTEMA." );
                        } else {
                            System.out.println( "\nINGRESE EL RUT DEL PROFESOR QUE DESEA ELIMINAR: " );
                            rut = lector.readLine();
                            if ( colegio.verificarProfesor( rut ) ) {
                                System.out.println( "\n¡PROFESOR ENCONTRADO CON ÉXITO!" );
                                while ( iterar ) {
                                    System.out.println( "\n -------------------------------------------------------------------------" );
                                    System.out.println( "|            ¿ESTÁ SEGURO DE QUE DESEA ELIMINAR ESTE PROFESOR?            |" );
                                    System.out.println( " -------------------------------------------------------------------------");
                                    System.out.println( "  PROFESOR: " + colegio.obtenerNombreProfesor( rut ) + " (" + rut + ")" );
                                    System.out.println( " -------------------------------------------------------------------------");
                                    System.out.println( "|                          ¿CONFIRMAR OPERACIÓN?                          |" );
                                    System.out.println( " -------------------------------------------------------------------------" );
                                    System.out.println( "|  1. SÍ                                                                  |" );
                                    System.out.println( "|  0. NO                                                                  |" );
                                    System.out.println( " -------------------------------------------------------------------------" );
                                    System.out.println( "\nINGRESE LA OPCIÓN QUE DESEA REALIZAR: " );
                                    opcion = lector.readLine();
                                                        
                                    switch( opcion ) {
                                        case "1":
                                            colegio.eliminarProfesor( rut );
                                            System.out.println( "\nEL PROFESOR HA SIDO ELIMINADO CON ÉXITO." );
                                            iterar = false;
                                            break;
                                                                
                                        case "0":
                                            System.out.println( "\nEL PROFESOR NO HA SIDO ELIMINADO." );
                                            iterar = false;
                                            break;
                                                            
                                        default:
                                            System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                                            break;
                                    }
                                }
                            } else {
                                System.out.println( "\nERROR AL ELIMINAR PROFESOR. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR." );
                            }
                        }
                        break;
            
                    case "0":
                        if ( rol == 5 ) {
                            System.out.println( "\nSESIÓN CERRADA CON ÉXITO. ¡HASTA LA PRÓXIMA!" );
                            saltar = true;
                            rol = 0;
                        } else {
                            saltar = true;       
                        }
                        break;
            
                    default:
                        System.out.println( "\nERROR AL EJECUTAR LA OPCIÓN. LA OPCIÓN INGRESADA NO ES VÁLIDA, INTENTE NUEVAMENTE." );
                        break;
                }
            }
        }
    }
    
}
