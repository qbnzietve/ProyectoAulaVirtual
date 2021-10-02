package com.mycompany.proyectoaulavirtual;

import java.util.*;     // Se importa la librería de listas

public class Colegio {
    
    private ArrayList<Alumno> listaAlumnos = null;     
    private ArrayList<Profesor> listaProfesores = null;     
    private Map<String, Alumno> mapaAlumnos = null;
    private Map<String, Profesor> mapaProfesores = null;
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
    
    public boolean verificarAlumno( String rut ) {
        if ( this.mapaAlumnos.containsKey( rut ) ) {
            return true;
        }
        return false;
    }
    
    public boolean esNumero( String n ) {
        try {
            Double.parseDouble( n );
            return true;
        } catch( NumberFormatException e ) {
            return false;
        }
    }
    
    public void inscribirAsignaturaAlumno( String rut, Asignatura a ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                this.listaAlumnos.get( i ).inscribirAsignatura( a );
            }
        }
    }
    
    public boolean verificarAsignaturaAlumno( String rut, String clave ) {
        this.alumnoBuscado = ( Alumno ) this.mapaAlumnos.get( rut );
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.alumnoBuscado.getRut().equals( this.listaAlumnos.get( i ).getRut() ) ) {
                if ( this.listaAlumnos.get( i ).verificarAsignatura( clave ) ) {
                    return true;
                }
            }
        }
        return false;
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
    
    public void agregarProfesor( Profesor a ) {
        this.listaProfesores.add( a );
        this.mapaProfesores.put( a.getRut(), a );
    }
    
    public boolean verificarProfesor( String rut ) {
        if ( this.mapaProfesores.containsKey( rut ) ) {
            return true;
        }
        return false;
    }
    
    public void inscribirAsignaturaProfesor( String rut, Asignatura a ) {
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.profesorBuscado.getRut().equals( this.listaProfesores.get( i ).getRut() ) ) {
                this.listaProfesores.get( i ).inscribirAsignatura( a );
            }
        }
    }
    
    public boolean verificarAsignaturaProfesor( String rut, String clave ) {
        this.profesorBuscado = ( Profesor ) this.mapaProfesores.get( rut );
        for ( int i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.profesorBuscado.getRut().equals( this.listaProfesores.get( i ).getRut() ) ) {
                if ( this.listaProfesores.get( i ).verificarAsignatura( clave ) ) {
                    return true;
                }
            }
        }
        return false;
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
    
    public void consultarCurso( String clave ) {
        int i, k = 0, aux = 0;
        int contadorProfesor = 0;
        int contadorAlumno = 0;
        
        for ( i = 0; i < this.listaProfesores.size(); i++ ) {
            if ( this.listaProfesores.get( i ).verificarAsignatura( clave ) ) {
                contadorProfesor++;
            }
        }
        
        for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
            if ( this.listaAlumnos.get( i ).verificarAsignatura( clave ) ) {
                contadorAlumno++;
            }
        }
        
        if ( contadorProfesor == 0 ) {
            if ( contadorAlumno == 0 ) {
                System.out.println( "\nERROR AL BUSCAR CURSO. LA CLAVE INGRESADA NO SE CORRESPONDE CON LA DE NINGÚN CURSO REGISTRADO." );
            }
            else {
                System.out.println( "\n ------------------------------------------------------------------------" );
                System.out.println( "|                            CURSO ENCONTRADO                            |");
                System.out.println( " ------------------------------------------------------------------------");
                System.out.print( "  CURSO: " );
                for ( i = 0; i < this.listaAlumnos.size(); i++ ) {
                    if ( this.listaAlumnos.get( i ).verificarAsignatura( clave ) && aux == 0 ) {
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
                    if ( this.listaAlumnos.get( i ).verificarAsignatura( clave ) ) {
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
                if ( this.listaProfesores.get( i ).verificarAsignatura( clave ) && aux == 0 ) {
                    this.listaProfesores.get( i ).mostrarDatosAsignatura( clave );
                    aux++;
                }
            }
            System.out.println( " ------------------------------------------------------------------------");
            System.out.println( "  PROFESOR(ES) A CARGO " );
            System.out.println( " ------------------------------------------------------------------------");
            for ( i = 0; i < this.listaProfesores.size(); i++ ) {
                if ( this.listaProfesores.get( i ).verificarAsignatura( clave ) ) {
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
                    if ( this.listaAlumnos.get( i ).verificarAsignatura( clave ) ) {
                        this.listaAlumnos.get( i ).mostrarAlumnoAsignatura( k );
                        k++;
                    }
                }
            }
        }
    }
    
}
