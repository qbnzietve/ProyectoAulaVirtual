package interfaz;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Colegio {
    
    private ArrayList<Usuario> listaUsuarios = null;
    private ArrayList<Persona> listaAlumnos = null;     
    private ArrayList<Persona> listaProfesores = null;    
    private Map<String, Usuario> mapaUsuarios = null;
    private Map<String, Persona> mapaAlumnos = null;
    private Map<String, Persona> mapaProfesores = null;
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
        direccion = direccion.toLowerCase();
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
    
    public void agregarAlumno( Persona a ) {
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
    
    public void mostrarAlumnosVentana() {
        /*
        System.out.println( "\n ------------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE ALUMNOS                            |");
        System.out.println( " ------------------------------------------------------------------------");
        */
        for ( int i = this.listaAlumnos.size() - 1; i >= 0; i-- ) {
            this.listaAlumnos.get( i ).mostrarDatosVentana( i );
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
    
    public void consultarAlumnoVentana( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            /*System.out.println( "\n -----------------------------------------------------------------------" );
            System.out.println( "|                           ALUMNO ENCONTRADO                           |");
            System.out.println( " -----------------------------------------------------------------------");*/
            this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
            this.alumnoBuscado.mostrarDatosVentana();
        }
        else {
            JOptionPane.showMessageDialog( null, "ERROR AL BUSCAR ALUMNO.\nEL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO REGISTRADO." );
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
    
    public void mostrarCursosAlumnoVentana( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
            this.alumnoBuscado.mostrarCursosVentana();
        }
        else {
            JOptionPane.showMessageDialog( null, "ERROR AL MOSTRAR CURSOS DEL ALUMNO.\nEL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN ALUMNO REGISTRADO." );
        }
    }
    
    public boolean verificarEvaluacionAlumno( String rut, String clave, String evaluacion ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                 return this.listaAlumnos.get( i ).verificarEvaluacion( clave, evaluacion );
            }
        }
        return false;
    }
    
    public void agregarNotaAlumno( String rut, String clave, Nota nota ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                this.listaAlumnos.get( i ).agregarNota( clave, nota );
            }
        }
    }
    
    public void mostrarNotasAlumno( String rut ) {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).getRut().equals( rut ) ) {
                this.listaAlumnos.get( i ).mostrarNotas();
            }
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
    
    public void agregarProfesor( Persona a ) {
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
    
    public void mostrarProfesoresVentana() {
        /*System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                          LISTA DE PROFESORES                          |");
        System.out.println( " -----------------------------------------------------------------------");*/
        
        for ( int i = this.listaProfesores.size() - 1; i >= 0; i-- ) {
            this.listaProfesores.get( i ).mostrarDatosVentana( i );
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
    
    public void consultarProfesorVentana( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            /*System.out.println( "\n -----------------------------------------------------------------------" );
            System.out.println( "|                          PROFESOR ENCONTRADO                          |");
            System.out.println( " -----------------------------------------------------------------------");*/
            this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
            this.profesorBuscado.mostrarDatosVentana();
        }
        else {
            JOptionPane.showMessageDialog( null, "ERROR AL BUSCAR PROFESOR.\nEL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR REGISTRADO." );
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
    
    public void mostrarCursosProfesorVentana( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
            this.profesorBuscado.mostrarCursosVentana();
        }
        else {
            JOptionPane.showMessageDialog( null, "ERROR AL MOSTRAR CURSOS DEL PROFESOR.\nEL RUT INGRESADO NO SE CORRESPONDE CON EL DE NINGÚN PROFESOR REGISTRADO." );
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
        double promedio = 0, valor = 0;
        
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
            } else {
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
                        this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                        System.out.println( " ------------------------------------------------------------------------");
                        valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                        if ( valor != 0 ) {
                            promedio = promedio + valor;
                        } else {
                            contadorAlumno--;
                        }
                        k++;
                    }
                }
                if ( promedio > 0 && contadorAlumno > 0 ) {
                    promedio = Math.round( ( promedio / contadorAlumno ) * 10 ) / 10d;
                    System.out.println( "  PROMEDIO CURSO: " + promedio );
                    System.out.println( " ------------------------------------------------------------------------");
                } else {
                    System.out.println( "  PROMEDIO CURSO: -" );
                    System.out.println( " ------------------------------------------------------------------------");
                }
            }
        } else {
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
                    System.out.println( " ------------------------------------------------------------------------");
                    k++;
                }
            }
            k = 0;
            if ( contadorAlumno == 0 ) {
                System.out.println( "  LISTA DE ALUMNOS " );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  No hay alumnos inscritos en este curso." );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  PROMEDIO CURSO: -" );
                System.out.println( " ------------------------------------------------------------------------");
            } else {
                System.out.println( "  LISTA DE ALUMNOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                        System.out.println( " ------------------------------------------------------------------------");
                        valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                        if ( valor != 0 ) {
                            promedio = promedio + valor;
                        } else {
                            contadorAlumno--;
                        }
                        k++;
                    }
                }
                if ( promedio > 0 && contadorAlumno > 0 ) {
                    promedio = Math.round( ( promedio / contadorAlumno ) * 10 ) / 10d;
                    System.out.println( "  PROMEDIO CURSO: " + promedio );
                    System.out.println( " ------------------------------------------------------------------------");
                } else {
                    System.out.println( "  PROMEDIO CURSO: -" );
                    System.out.println( " ------------------------------------------------------------------------");
                }
            }
        }
    }
    
    public void mostrarAlumnosSobrePromedio( String clave ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0, promedio = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor != 0 ) {
                        promedio = promedio + valor;
                    } else {
                        contadorAlumno--;
                    }
                }
            }
            if ( promedio > 0 && contadorAlumno > 0 ) {
                promedio = Math.round( ( promedio / contadorAlumno ) * 10 ) / 10d;
                System.out.println( "\n -------------------------------------------------------------------------" );
                System.out.println( "|                        ALUMNOS SOBRE EL PROMEDIO                        |");
                System.out.println( " -------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " -------------------------------------------------------------------------");
                System.out.println( "  PROMEDIO CURSO: " + promedio );
                System.out.println( " -------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " -------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor > promedio ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " -------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " -------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosBajoPromedio( String clave ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0, promedio = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor != 0 ) {
                        promedio = promedio + valor;
                    } else {
                        contadorAlumno--;
                    }
                }
            }
            if ( promedio > 0 && contadorAlumno > 0 ) {
                promedio = Math.round( ( promedio / contadorAlumno ) * 10 ) / 10d;
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                        ALUMNOS BAJO EL PROMEDIO                        |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  PROMEDIO CURSO: " + promedio );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor < promedio ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " ------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " ------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosEnElPromedio( String clave ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0, promedio = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor != 0 ) {
                        promedio = promedio + valor;
                    } else {
                        contadorAlumno--;
                    }
                }
            }
            if ( promedio > 0 && contadorAlumno > 0 ) {
                promedio = Math.round( ( promedio / contadorAlumno ) * 10 ) / 10d;
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                         ALUMNOS EN EL PROMEDIO                         |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  PROMEDIO CURSO: " + promedio );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor == promedio ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " ------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " ------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosSobreValor( String clave, double valorNota ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor == 0 ) {
                        contadorAlumno--;
                    }
                }
            }
            if ( contadorAlumno > 0 ) {
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                        ALUMNOS SOBRE VALOR DADO                        |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  VALOR INGRESADO: " + valorNota );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor > valorNota ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " ------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " ------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosBajoValor( String clave, double valorNota ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor == 0 ) {
                        contadorAlumno--;
                    }
                }
            }
            if ( contadorAlumno > 0 ) {
                System.out.println( "\n -------------------------------------------------------------------------" );
                System.out.println( "|                         ALUMNOS BAJO VALOR DADO                         |");
                System.out.println( " -------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " -------------------------------------------------------------------------");
                System.out.println( "  VALOR INGRESADO: " + valorNota );
                System.out.println( " -------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " -------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor < valorNota ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " -------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " -------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosEntreValor( String clave, double valor1, double valor2 ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0;
        double menor = 0, mayor = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor == 0 ) {
                        contadorAlumno--;
                    }
                }
            }
            if ( contadorAlumno > 0 ) {
                menor = valor1;
                if ( menor < valor2 ) {
                    mayor = valor2;
                } else {
                    menor = valor2;
                    mayor = valor1;
                }
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                     ALUMNOS ENTRE RANGO DE VALORES                     |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  RANGO DE VALORES: [ " + menor + " - " + mayor + " ]" );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor >= menor && valor <= mayor ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " ------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " ------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosRepitentes( String clave ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor == 0 ) {
                        contadorAlumno--;
                    }
                }
            }
            if ( contadorAlumno > 0 ) {
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                   ALUMNOS EN SITUACIÓN DE REPITENCIA                   |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  PROMEDIO APROBACIÓN: 4.0" );
                System.out.println( " ------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " ------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        valor = Math.round( valor * 10 ) / 10d;
                        if ( valor < 4.0 ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " ------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " ------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnosSinNotas( String clave ) {
        int i = 0, k = 0, aux = 0;
        int contadorAlumno = 0;
        double valor = 0;
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorAlumno == 0 ) {
            System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS INSCRITOS EN ESTE CURSO." );
        } else {
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                    valor = this.listaAlumnos.get( i ). calcularPromedioAsignatura( clave );
                    if ( valor == 0 ) {
                        contadorAlumno--;
                    }
                }
            }
            if ( contadorAlumno > 0 ) {
                System.out.println( "\n -------------------------------------------------------------------------" );
                System.out.println( "|                      ALUMNOS SIN NOTAS REGISTRADAS                      |");
                System.out.println( " -------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) && aux == 0 ) {
                        this.listaAlumnos.get( i ).mostrarDatosAsignatura( clave );
                        aux++;
                    }
                }
                System.out.println( " -------------------------------------------------------------------------");
                System.out.println( "  LISTA DE ALUMNOS ENCONTRADOS " );
                System.out.println( " -------------------------------------------------------------------------");
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarCurso( clave ) ) {
                        valor = this.listaAlumnos.get( i ).calcularPromedioAsignatura( clave );
                        if ( valor == 0 ) {
                            this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( clave, k );
                            System.out.println( " -------------------------------------------------------------------------");
                            k++;
                        }
                    }
                }
                if ( k == 0 ) {
                    System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                    System.out.println( " -------------------------------------------------------------------------");
                }
            } else {
                System.out.println( "\nERROR AL EVALUAR PROMEDIOS. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN ESTE CURSO." );
            }
        }
    }
    
    public void mostrarAlumnoPromedioMasAlto() {
        int i = 0, k = 0, repeticiones = -1;
        double promedioMasAlto = 0, promedio = 0;
        
        while ( promedioMasAlto == 0 && i < this.listaAlumnos.size() ) {
            promedioMasAlto = this.listaAlumnos.get( i ).calcularPromedioGeneral();
            i++;
        }
        
        if ( promedioMasAlto != 0 ) {
            System.out.println( "\n -------------------------------------------------------------------------" );
            System.out.println( "|                 ALUMNO(S) CON PROMEDIO GENERAL MÁS ALTO                 |");
            System.out.println( " -------------------------------------------------------------------------");
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                if ( promedio > promedioMasAlto && promedio != 0 ) {
                    promedioMasAlto = promedio;
                } else {
                    if ( promedio == promedioMasAlto ) {
                        repeticiones++;
                    }
                }
            }
            if ( repeticiones != 0 ) {
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                    if ( promedio == promedioMasAlto ) {
                        this.listaAlumnos.get( i ).mostrarDatos( k );
                        k++;
                    }
                }
            } else {
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                    if ( promedio == promedioMasAlto ) {
                        this.listaAlumnos.get( i ).mostrarDatos();
                    }
                }
            }
        } else {
            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN EL SISTEMA." );
        }
    }
    
    public void mostrarAlumnoPromedioMasBajo() {
        int i = 0, k = 0, repeticiones = -1;
        double promedioMasBajo = 0, promedio = 0;
        
        while ( promedioMasBajo == 0 && i < this.listaAlumnos.size() ) {
            promedioMasBajo = this.listaAlumnos.get( i ).calcularPromedioGeneral();
            i++;
        }
        
        if ( promedioMasBajo != 0 ) {
            System.out.println( "\n -------------------------------------------------------------------------" );
            System.out.println( "|                 ALUMNO(S) CON PROMEDIO GENERAL MÁS BAJO                 |");
            System.out.println( " -------------------------------------------------------------------------");
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                if ( promedio < promedioMasBajo && promedio != 0 ) {
                    promedioMasBajo = promedio;
                } else {
                    if ( promedio == promedioMasBajo ) {
                        repeticiones++;
                    }
                }
            }
            if ( repeticiones != 0 ) {
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                    if ( promedio == promedioMasBajo ) {
                        this.listaAlumnos.get( i ).mostrarDatos( k );
                        k++;
                    }
                }
            } else {
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                    if ( promedio == promedioMasBajo ) {
                        this.listaAlumnos.get( i ).mostrarDatos();
                    }
                }
            }
        } else {
            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN EL SISTEMA." );
        }
    }
    
    public void totalAlumnosPromedioSobresaliente() {
        int i = 0, k = 0, valor = 0, promediosSobresalientes = 0;
        double promedio = 0;
        
        while ( promedio == 0  && i < this.listaAlumnos.size() ) {
            promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
            i++;
        }
        
        if ( promedio != 0 ) {
            System.out.println( "\n ------------------------------------------------------------------------" );
            System.out.println( "|                   ALUMNOS CON PROMEDIO SOBRESALIENTE                   |");
            System.out.println( " ------------------------------------------------------------------------");
            System.out.println( "  PROMEDIO REQUERIDO: 6.0 Ó SUPERIOR" );
            System.out.println( " ------------------------------------------------------------------------");
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                if ( promedio != 0 ) {
                    valor = this.listaAlumnos.get( i ).promediosSobresalientes( k );
                    if ( valor != 0 ) {
                        System.out.println( "  NÚMERO DE CASOS ALUMNO: " + valor );
                        System.out.println( " ------------------------------------------------------------------------");
                        promediosSobresalientes = promediosSobresalientes + valor;
                        k++;
                    }
                }
            }
            if ( promediosSobresalientes != 0 ) {
                System.out.println( "  NÚMERO TOTAL DE CASOS: " + promediosSobresalientes );
                System.out.println( " ------------------------------------------------------------------------");
            } else {
                System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                System.out.println( " ------------------------------------------------------------------------");
            }
        } else {
            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN EL SISTEMA." );
        }
    }
    
    public void totalAlumnosEnSituaciónRepitencia() {
        int i = 0, k = 0, valor = 0, cursosEnRiesgo = 0;
        double promedio = 0;
        
        while ( promedio == 0  && i < this.listaAlumnos.size() ) {
            promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
            i++;
        }
        
        if ( promedio != 0 ) {
            System.out.println( "\n ------------------------------------------------------------------------" );
            System.out.println( "|                   ALUMNOS EN SITUACIÓN DE REPITENCIA                   |");
            System.out.println( " ------------------------------------------------------------------------");
            System.out.println( "  PROMEDIO APROBACIÓN: 4.0" );
            System.out.println( " ------------------------------------------------------------------------");
            for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                promedio = this.listaAlumnos.get( i ).calcularPromedioGeneral();
                if ( promedio != 0 ) {
                    valor = this.listaAlumnos.get( i ).cursosEnRiesgo( k );
                    if ( valor != 0 ) {
                        System.out.println( "  NÚMERO DE CASOS ALUMNO: " + valor );
                        System.out.println( " ------------------------------------------------------------------------");
                        cursosEnRiesgo = cursosEnRiesgo + valor;
                        k++;
                    }
                }
            }
            if ( cursosEnRiesgo != 0 ) {
                System.out.println( "  NÚMERO TOTAL DE CASOS: " + cursosEnRiesgo );
                System.out.println( " ------------------------------------------------------------------------");
            } else {
                System.out.println( "  No hay alumnos que cumplan con los requisitos de búsqueda.");
                System.out.println( " ------------------------------------------------------------------------");
            }
        } else {
            System.out.println( "\nERROR AL REVISAR SITUACIÓN ACADÉMICA. NO HAY ALUMNOS CON NOTAS REGISTRADAS EN EL SISTEMA." );
        }
    }
    
}
