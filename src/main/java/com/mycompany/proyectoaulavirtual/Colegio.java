package com.mycompany.proyectoaulavirtual;

import java.io.*;
import java.util.*;     // Se importa la librería de listas

public class Colegio {
    
    private ArrayList<Usuario> listaUsuarios = null;
    private ArrayList<Alumno> listaAlumnos = null;     
    private ArrayList<Profesor> listaProfesores = null;    
    private Map<String, Usuario> mapaUsuarios = null;
    private Map<String, Alumno> mapaAlumnos = null;
    private Map<String, Profesor> mapaProfesores = null;
    private Usuario usuarioBuscado;
    private Alumno alumnoBuscado;
    private Profesor profesorBuscado;

    public Colegio() {
        this.listaUsuarios = new ArrayList<>();
        this.listaAlumnos = new ArrayList<>();
        this.listaProfesores = new ArrayList<>();
        this.mapaUsuarios = new HashMap();
        this.mapaAlumnos = new HashMap();
        this.mapaProfesores = new HashMap();
    }
    
    // VERIFICAR
    
    public boolean esNumero( String n ) {
        try {
            Double.parseDouble( n );
            return true;
        } catch( NumberFormatException e ) {
            return false;
        }
    }
    
    // VERIFICAR
    
    //------------------------------------------------------------------------------------------------------------
    
    // ARCHIVO TXT
    
    public void crearArchivotxt( String direccion ) throws IOException {
        FileWriter fichero = new FileWriter( direccion );
        fichero.write( "\n ------------------------------------------------------------------------\n" );
        fichero.write( "|                            LISTA DE ALUMNOS                            |\n");
        fichero.write( " ------------------------------------------------------------------------\n");
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            this.listaAlumnos.get( i ).mostrarDatos( i , fichero );
        }
        
        fichero.write( "\n -----------------------------------------------------------------------\n" );
        fichero.write( "|                          LISTA DE PROFESORES                          |\n");
        fichero.write( " -----------------------------------------------------------------------\n");
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            this.listaProfesores.get( i ).mostrarDatos( i , fichero );
        }
        fichero.close();
    }
    
    // ARCHIVO TXT
    
    //------------------------------------------------------------------------------------------------------------
    
    // MÉTODOS USUARIO
    
    public void registrarUsuario( Usuario a ) {
        this.listaUsuarios.add( a );
        this.mapaUsuarios.put( a.getRut(), a );
    }
    
    public boolean hayUsuarios() {
        return this.listaUsuarios.isEmpty();
    }
    
    public boolean verificarRutUsuario( String rut ) {
        if ( this.mapaUsuarios.containsKey( rut ) ) {
            return true;
        }
        return false;
    }
    
    public boolean verificarNombreUsuario( String username ) {
        username = username.toLowerCase();
        for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
            if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarUsuario( String username ) {
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            return true;
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verificarContraseña( String username, String contraseña ) {
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
            contraseña = this.usuarioBuscado.convertirContraseña( contraseña );
            if ( this.usuarioBuscado.getContraseña().equals( contraseña ) ) {
                return true;
            }
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    username = this.listaUsuarios.get( i ).getRut();
                    this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
                    contraseña = this.usuarioBuscado.convertirContraseña( contraseña );
                    if ( this.usuarioBuscado.getContraseña().equals( contraseña ) ) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    
    public String recuperarContraseñaUsuario( String username ) {
        String contraseña = null;
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
            contraseña = this.usuarioBuscado.recuperarContraseña( contraseña );
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    username = this.listaUsuarios.get( i ).getRut();
                    this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
                    contraseña = this.usuarioBuscado.recuperarContraseña( contraseña );
                }
            }
        }
        return contraseña;
    }
    
    public int obtenerRolUsuario( String username ) {
        int rol = 0;
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
            rol = this.usuarioBuscado.getRol();
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    username = this.listaUsuarios.get( i ).getRut();
                    this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
                    rol = this.usuarioBuscado.getRol();
                }
            }
        }
        return rol;
    }
    
    public String obtenerRutUsuario( String username ) {
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            return username;
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    username = this.listaUsuarios.get( i ).getRut();
                    return username;
                }
            }
        }
        return username;
    }
    
    public String obtenerNombreUsuario( String username ) {
        username = username.toLowerCase();
        if ( this.mapaUsuarios.containsKey( username ) ) {
            this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
            return this.usuarioBuscado.getNombre();
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    username = this.listaUsuarios.get( i ).getNombre();
                    return username;
                }
            }
        }
        return username;
    }
    
    public int obtenerEdadUsuario( String username ) {
        username = username.toLowerCase();
        int edad = 0;
        if ( this.mapaUsuarios.containsKey( username ) ) {
            this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( username );
            return this.usuarioBuscado.getEdad();
        } else {
            for ( int i = 0; i < this.listaUsuarios.size(); i++ ) {
                if ( this.listaUsuarios.get( i ).getUsername().toLowerCase().equals( username ) ) {
                    edad = this.listaUsuarios.get( i ).getEdad();
                    return edad;
                }
            }
        }
        return edad;
    }
    
    public void mostrarDatosUsuario( String rut, int rol ) {
        this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( rut );
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                               MI PERFIL                               |");
        System.out.println( " -----------------------------------------------------------------------");
        if ( rol == 1 ) {
            System.out.println( "  USUARIO: " + this.usuarioBuscado.getUsername() + " (USUARIO NORMAL)");
        } else {
            System.out.println( "  USUARIO: " + this.usuarioBuscado.getUsername() + " (APODERADO)");
        }
        System.out.println( " -----------------------------------------------------------------------");
        this.usuarioBuscado.mostrarDatos();
    }
    
    //MÉTODOS USUARIO
    
    //------------------------------------------------------------------------------------------------------------
    
    // MÉTODOS ALUMNO
    
    public void agregarAlumno( Alumno a ) {
        this.listaAlumnos.add( a );
        this.mapaAlumnos.put( a.getRut(), a );
    }
    
    public boolean hayAlumnos() {
        return this.listaAlumnos.isEmpty();
    }
    
    public boolean verificarAlumno( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            return true;
        }
        return false;
    }
    
    public String obtenerNombreAlumno( String rut ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        return this.alumnoBuscado.getNombre();
    }
    
    public void registrarApoderadoAlumno( String rut, Apoderado a ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                this.listaAlumnos.get( i ).registrarApoderado( a );
            }
        }
    }
    
    public boolean verificarApoderadoAlumno( String rut ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        if ( this.alumnoBuscado.verificarApoderado() ) {
            return true;
        }/*
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                if ( this.listaAlumnos.get( i ).verificarApoderado( a.getRut() ) ) {
                    return true;
                }
            }
        }*/
        return false;
    }
    
    public void inscribirCursoAlumno( String rut, Asignatura a ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                this.listaAlumnos.get( i ).inscribirCurso( a );
            }
        }
    }
    
    public int cantidadCursosAlumno( String rut ) {
        int cont = 0;
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                cont = this.listaAlumnos.get( i ).contarCursos();
            }
        }
        return cont;
    }
    
    public boolean verificarCursoAlumno( String rut, String clave ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String obtenerNombreCursoAlumno( String rut, String clave ) {
        String nombre;
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        nombre = this.alumnoBuscado.obtenerNombreCurso( clave );
        return nombre;
    }
    
    public void mostrarDatosAlumno( String rut ) {
        this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( rut );
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                               MI PERFIL                               |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  USUARIO: " + this.usuarioBuscado.getUsername() + " (ALUMNO)");
        System.out.println( " -----------------------------------------------------------------------");
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        this.alumnoBuscado.mostrarDatos();
    }
    
    public void mostrarAlumnos() {
        System.out.println( "\n ------------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE ALUMNOS                            |");
        System.out.println( " ------------------------------------------------------------------------");
        
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            this.listaAlumnos.get( i ).mostrarDatos( i );
        }
    }
    
    public void consultarAlumno( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            System.out.println( "\n -----------------------------------------------------------------------" );
            System.out.println( "|                           ALUMNO ENCONTRADO                           |");
            System.out.println( " -----------------------------------------------------------------------");
            this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
            this.alumnoBuscado.mostrarDatos();
        }
        else {
            System.out.println( "\nERROR AL BUSCAR ALUMNO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO REGISTRADO." );
        }
    }
    
    public void mostrarCursosAlumno( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
            this.alumnoBuscado.mostrarCursos();
        }
        else {
            System.out.println( "\nERROR AL MOSTRAR CURSOS DEL ALUMNO. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO REGISTRADO." );
        }
    }
    
    public void reemplazarCursoAlumno( String rut, String clave, Asignatura a ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get(i).getRut().equals( rut ) ) {
                this.listaAlumnos.get(i).reemplazarCurso( clave, a );
            }
        }
    }
    
    public void eliminarCursoAlumno( String rut, String clave ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                this.listaAlumnos.get( i ).eliminarCurso( clave );
            }
        }
    }
    
    public void eliminarAlumno( String rut ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                this.listaAlumnos.remove( i );
                this.mapaAlumnos.remove( rut );
            }
        }
    }
    
    //MÉTODOS ALUMNO
    
    //------------------------------------------------------------------------------------------------------------
    
    // MÉTODOS PROFESOR
    
    public void agregarProfesor( Profesor a ) {
        this.listaProfesores.add( a );
        this.mapaProfesores.put( a.getRut(), a );
    }
    
    public boolean hayProfesores() {
        return this.listaProfesores.isEmpty();
    }
    
    public boolean verificarProfesor( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            return true;
        }
        return false;
    }
    
    public String obtenerNombreProfesor( String rut ) {
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        return this.profesorBuscado.getNombre();
    }
    
    public void inscribirCursoProfesor( String rut, Asignatura a ) {
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.profesorBuscado.getRut().equals( this.listaProfesores.get( i ).getRut() ) ) {
                this.listaProfesores.get( i ).inscribirCurso( a );
            }
        }
    }
    
    public int cantidadCursosProfesor( String rut ) {
        int cont = 0;
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get( i ).getRut().equals( rut ) ) {
                cont = this.listaProfesores.get( i ).contarCursos();
            }
        }
        return cont;
    }
    
    public boolean verificarCursoProfesor( String rut, String clave ) {
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.profesorBuscado.getRut().equals( this.listaProfesores.get( i ).getRut() ) ) {
                if ( this.listaProfesores.get( i ).verificarCurso( clave ) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String obtenerNombreCursoProfesor( String rut, String clave ) {
        String nombre;
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        nombre = this.profesorBuscado.obtenerNombreCurso( clave );
        return nombre;
    }
    
    public void mostrarDatosProfesor( String rut ) {
        this.usuarioBuscado = ( Usuario ) this.mapaUsuarios.get( rut );
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                               MI PERFIL                               |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  USUARIO: " + this.usuarioBuscado.getUsername() + " (PROFESOR)");
        System.out.println( " -----------------------------------------------------------------------");
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        this.profesorBuscado.mostrarDatos();
    }
    
    public void mostrarProfesores() {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                          LISTA DE PROFESORES                          |");
        System.out.println( " -----------------------------------------------------------------------");
        
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            this.listaProfesores.get( i ).mostrarDatos( i );
        }
    }
    
    public void consultarProfesor( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            System.out.println( "\n -----------------------------------------------------------------------" );
            System.out.println( "|                          PROFESOR ENCONTRADO                          |");
            System.out.println( " -----------------------------------------------------------------------");
            this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
            this.profesorBuscado.mostrarDatos();
        }
        else {
            System.out.println( "\nERROR AL BUSCAR PROFESOR. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR REGISTRADO." );
        }
    }
    
    public void mostrarCursosProfesor( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
            this.profesorBuscado.mostrarCursos();
        }
        else {
            System.out.println( "\nERROR AL MOSTRAR CURSOS DEL PROFESOR. EL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR REGISTRADO." );
        }
    }
    
    public void reemplazarCursoProfesor( String rut, String clave, Asignatura a ) {
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get(i).getRut().equals( rut ) ) {
                this.listaProfesores.get(i).reemplazarCurso( clave, a );
            }
        }
    }
    
    public void eliminarCursoProfesor( String rut, String clave ) {
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get( i ).getRut().equals( rut ) ) {
                this.listaProfesores.get( i ).eliminarCurso( clave );
            }
        }
    }
    
    public void eliminarProfesor( String rut ) {
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get( i ).getRut().equals( rut ) ) {
                this.listaProfesores.remove( i );
                this.mapaProfesores.remove( rut );
            }
        }
    }
    
    //MÉTODOS PROFESOR
    
    //------------------------------------------------------------------------------------------------------------
    
    // MÉTODOS CURSO
    
    public void mostrarCursos( String rut, int rol ) {
        if ( rol == 2 ) {
            this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
            this.alumnoBuscado.mostrarCursos( rol );
        } else {
            this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
            this.profesorBuscado.mostrarCursos( rol );
        }
    }
    
    public void consultarCurso( String clave ) {
        int i, k = 0, aux = 0;
        int contadorProfesor = 0;
        int contadorAlumno = 0;
        
        for ( i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get( i ).verificarCurso( clave ) ) {
                contadorProfesor++;
            }
        }
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorProfesor == 0 ) {
            if ( contadorAlumno == 0 ) {
                System.out.println( "\nERROR AL CONSULTAR CURSO. LA CLAVE INGRESADA NO SE CORRESPONDE CON LA DE NINGÚN CURSO REGISTRADO." );
            }
            else {
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                            CURSO ENCONTRADO                            |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  PROFESOR(ES) A CARGO " );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  No hay ningún profesor a cargo de este curso." );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( k );
                        k++;
                    }
                }
            }
        }
        else {
            System.out.println( "\n ------------------------------------------------------------------------" );
            System.out.println( "|                            CURSO ENCONTRADO                            |");
            System.out.println( " ------------------------------------------------------------------------");
            System.out.print( "  CURSO: " );
            for ( i = 0; i < this.listaProfesores.size(); i++ ) {
                if ( this.listaProfesores.get( i ).verificarCurso( clave ) && aux == 0 ) {
                    this.listaProfesores.get( i ).mostrarDatosAsignatura( clave );
                    aux++;
                }
            }
            System.out.println( " ------------------------------------------------------------------------");
            System.out.println( "  PROFESOR(ES) A CARGO " );
            System.out.println( " ------------------------------------------------------------------------");
            for ( i = 0; i < this.listaProfesores.size(); i++ ) {
                if ( this.listaProfesores.get( i ).verificarCurso( clave ) ) {
                    this.listaProfesores.get( i ).mostrarProfesorAsignatura( k );
                    k++;
                }
            }
            k = 0;
            if ( contadorAlumno == 0 ) {
                System.out.println( "  LISTA DE ALUMNOS " );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  No hay alumnos inscritos en este curso." );
                System.out.println( " ------------------------------------------------------------------------");
            }
            else {
                System.out.println( "  LISTA DE ALUMNOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( k );
                        k++;
                    }
                }
            }
        }
    }
    
}
