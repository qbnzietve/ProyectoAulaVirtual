package interfaz;

import java.io.*;
import java.util.*;

public class Profesor extends Persona {
    
    private ArrayList<Asignatura> cursosImpartidos = null;
    private Map<String, Asignatura> mapaCursos = null;
    private Asignatura cursoBuscado;
    
    public Profesor( String nombre, String rut, int edad ) {
        super( nombre, rut, edad );
        this.cursosImpartidos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    @Override
    public void inscribirCurso( Asignatura a ) {
        this.cursosImpartidos.add( a );
        this.mapaCursos.put( a.getClave(), a );
    }
    
    @Override
    public int contarCursos() {
        int cont = 0;
        cont = this.cursosImpartidos.size();
        return cont;
    }
    
    @Override
    public boolean verificarCurso( String clave ) {
        if ( this.mapaCursos.containsKey( clave ) ) {
            return true;
        }
        else
            return false;
    }
    
    @Override
    public String obtenerNombreCurso( String clave ) {
        this.cursoBuscado = this.mapaCursos.get( clave );
        return this.cursoBuscado.getNombre();
    }
    
    @Override
    public void mostrarDatos( int i ) {
        /*int k;
        System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + getNombre() );
        System.out.println( "     | RUT: " + getRut() );
        System.out.println( "     | EDAD: " + getEdad() );
        if ( !this.cursosImpartidos.isEmpty() ) {
            System.out.print( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosImpartidos.size() - 1 ); k++) {
                System.out.print( this.cursosImpartidos.get( k ).getClave() + " | ");
            }
            System.out.println( this.cursosImpartidos.get( k ).getClave() );
        }
        else {
            System.out.println( "     | CURSOS: No hay cursos inscritos." );
        }
        System.out.println( " -----------------------------------------------------------------------");*/
        ListaProfesores p = new ListaProfesores();
        p.mostrarDatos( i, getNombre(), getRut(), getEdad(), this.cursosImpartidos );
    }
    
    @Override
    public void mostrarDatos() {
        /*int i;
        System.out.println( "  NOMBRE: " + getNombre() );
        System.out.println( "  RUT: " + getRut() );
        System.out.println( "  EDAD: " + getEdad() );
        if ( !this.cursosImpartidos.isEmpty() ) {
            System.out.print( "  CURSOS: " );
            for ( i = 0; i < ( this.cursosImpartidos.size() - 1 ); i++) {
                System.out.print( this.cursosImpartidos.get( i ).getClave() + " | ");
            }
            System.out.println( this.cursosImpartidos.get( i ).getClave() );
        }
        else {
            System.out.println( "  CURSOS: No hay cursos inscritos." );
        }
        System.out.println( " -----------------------------------------------------------------------");*/
        PerfilProfesor p = new PerfilProfesor();
        p.mostrarDatos( getNombre(), getRut(), getEdad(), this.cursosImpartidos );
    }
    
    @Override
    public void mostrarDatos( int i, FileWriter fichero ) throws IOException {
        int k;
        fichero.write( "  0" + ( i+1 ) + " | NOMBRE: " + getNombre() +"\n");
        fichero.write( "     | RUT: " + getRut() +"\n");
        fichero.write( "     | EDAD: " + getEdad() +"\n");
        if ( !this.cursosImpartidos.isEmpty() ) {
            fichero.write( "     | CURSOS: " );
            for ( k = 0; k < ( this.cursosImpartidos.size() - 1 ); k++ ) {
                fichero.write( this.cursosImpartidos.get( k ).getClave() + " | ");
            }
            fichero.write( this.cursosImpartidos.get( k ).getClave() +"\n");
        }
        else {
            fichero.write( "     | CURSOS: No hay cursos inscritos.\n" );
        }
        fichero.write( " ------------------------------------------------------------------------\n");
    }
    
    @Override
    public void mostrarCursos() {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  PROFESOR: " + getNombre() + " (" + getRut() + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosImpartidos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosImpartidos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    @Override
    public void mostrarCursos( int rol ) {
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosImpartidos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosImpartidos.get( i ).getClave() );
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    @Override
    public void reemplazarCurso( String clave, Asignatura a ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                this.mapaCursos.remove( this.cursosImpartidos.get( i ).getClave() );
                this.cursosImpartidos.set( i, a );
                this.mapaCursos.put( a.getClave(), a );
            }
        }
    }
    
    @Override
    public void eliminarCurso( String clave ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                this.cursosImpartidos.remove( i );
                this.mapaCursos.remove( clave );
            }
        }
    }
    
    @Override
    public void mostrarDatosAsignatura( String clave ) {
        for ( int i = 0; i < this.cursosImpartidos.size(); i++ ) {
            if ( this.cursosImpartidos.get( i ).getClave().equals( clave ) ) {
                System.out.println( this.cursosImpartidos.get( i ).getNombre() + " (" + this.cursosImpartidos.get( i ).getClave() + ")" );
            }
        }
    }
    
    @Override
    public void mostrarProfesorAsignatura( int k ) {
        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + getNombre() );
        System.out.println( "     | RUT: " + getRut() );
        System.out.println( "     | EDAD: " + getEdad() );
    }
    
    //
    //
    //
    
    @Override
    public void registrarApoderado( Apoderado a ) {
        
    }
    
    @Override
    public boolean verificarApoderado() {
        return true;
    }
    
    @Override
    public boolean verificarEvaluacion( String clave, String evaluacion ) {
        return true;
    }
    
    @Override
    public void agregarNota( String clave, Nota nota ) {
        
    }
    
    @Override
    public void mostrarNotas() {
        
    }
    
    @Override
    public void mostrarAlumnoAsignatura( String clave, int k ) {
        
    }
    
    @Override
    public double calcularPromedioAsignatura( String clave ) {
        return 0;
    }
    
    @Override
    public double calcularPromedioGeneral() {
        return 0;
    }
    
    @Override
    public int promediosSobresalientes( int k ) {
        return 0;
    }
    
    @Override
    public int cursosEnRiesgo( int k ) {
        return 0;
    }
    
}
