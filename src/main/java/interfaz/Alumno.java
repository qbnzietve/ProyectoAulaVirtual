package interfaz;

import java.io.*;
import java.util.*;

public class Alumno extends Persona {
    
    private Apoderado apoderado = null;
    private ArrayList<Asignatura> cursosInscritos = null;
    private Map<String, Asignatura> mapaCursos = null;
    private Asignatura cursoBuscado;
    
    public Alumno( String nombre, String rut, int edad ) {
        super( nombre, rut, edad );
        this.cursosInscritos = new ArrayList<>();
        this.mapaCursos = new HashMap();
    }
    
    @Override
    public void registrarApoderado( Apoderado a ) {
        this.apoderado = a;
    }
    
    @Override
    public boolean verificarApoderado() {
        if ( this.apoderado != null ) {
            return true;
        }
        return false;
    }
    
    @Override
    public void inscribirCurso( Asignatura a ) {
        this.cursosInscritos.add( a );
        this.mapaCursos.put( a.getClave(), a );
    }
    
    @Override
    public int contarCursos() {
        int cont = 0;
        cont = this.cursosInscritos.size();
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
        /*
        int k;
        double promedio = 0;
        System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + getNombre() );
        System.out.println( "     | RUT: " + getRut() );
        System.out.println( "     | EDAD: " + getEdad() );
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
        promedio = calcularPromedioGeneral();
        if ( promedio != 0 ) {
            System.out.println( "     | PROMEDIO GENERAL: " + promedio );
        } else {
            System.out.println( "     | PROMEDIO GENERAL: -" );
        }
        System.out.println( " ------------------------------------------------------------------------");
        */
        double promedio = 0;
        promedio = calcularPromedioGeneral();
        ListaAlumnos p = new ListaAlumnos();
        p.mostrarDatos( i, getNombre(), getRut(), getEdad(), this.cursosInscritos, promedio );
    }
    
    @Override
    public void mostrarDatos() {
        /*int i;
        double promedio = 0;
        System.out.println( "  NOMBRE: " + getNombre() );
        System.out.println( "  RUT: " + getRut() );
        System.out.println( "  EDAD: " + getEdad() );
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
        promedio = calcularPromedioGeneral();
        if ( promedio != 0 ) {
            System.out.println( "  PROMEDIO GENERAL: " + promedio );
        } else {
            System.out.println( "  PROMEDIO GENERAL: -" );
        }
        System.out.println( " -----------------------------------------------------------------------");*/
        double promedio = 0;
        promedio = calcularPromedioGeneral();
        PerfilAlumno p = new PerfilAlumno();
        p.mostrarDatos( getNombre(), getRut(), getEdad(), this.cursosInscritos, promedio );
    }
    
    @Override
    public void mostrarDatos( int i, FileWriter fichero ) throws IOException {
        int k;
        double promedio = 0;
        fichero.write( "  0" + ( i+1 ) + " | NOMBRE: " + getNombre() +"\n");
        fichero.write( "     | RUT: " + getRut() +"\n");
        fichero.write( "     | EDAD: " + getEdad() +"\n");
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
        promedio = calcularPromedioGeneral();
        if ( promedio != 0 ) {
            fichero.write( "     | PROMEDIO GENERAL: " + promedio + "\n" );
        } else {
            fichero.write( "     | PROMEDIO GENERAL: -\n" );
        }
        fichero.write( " ------------------------------------------------------------------------\n");
    }
    
    @Override
    public void mostrarCursos() {
        double promedio = 0;
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        System.out.println( "  ALUMNO: " + getNombre() + " (" + getRut() + ")" );
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosInscritos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosInscritos.get( i ).getClave() );
            if ( !this.cursosInscritos.get( i ).hayNotas() ) {
                System.out.print( "     | NOTAS: " );
                this.cursosInscritos.get( i ).mostrarNotas();
                promedio = this.cursosInscritos.get( i ).calcularPromedio();
                promedio = Math.round( promedio * 10 ) / 10d;
                System.out.println( "     | PROMEDIO: " + promedio );
            } else {
                System.out.println( "     | NOTAS: No hay notas registradas." );
                System.out.println( "     | PROMEDIO: -" );
            }
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    @Override
    public void mostrarCursos( int rol ) {
        double promedio = 0;
        System.out.println( "\n -----------------------------------------------------------------------" );
        System.out.println( "|                            LISTA DE CURSOS                            |");
        System.out.println( " -----------------------------------------------------------------------");
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            System.out.println( "  0" + ( i+1 ) + " | NOMBRE: " + this.cursosInscritos.get( i ).getNombre() );
            System.out.println( "     | CLAVE: " + this.cursosInscritos.get( i ).getClave() );
            if ( !this.cursosInscritos.get( i ).hayNotas() ) {
                System.out.print( "     | NOTAS: " );
                this.cursosInscritos.get( i ).mostrarNotas();
                promedio = this.cursosInscritos.get( i ).calcularPromedio();
                promedio = Math.round( promedio * 10 ) / 10d;
                System.out.println( "     | PROMEDIO: " + promedio );
            } else {
                System.out.println( "     | NOTAS: No hay notas registradas." );
                System.out.println( "     | PROMEDIO: -" );
            }
            System.out.println( " -----------------------------------------------------------------------");
        }
    }
    
    @Override
    public boolean verificarEvaluacion( String clave, String evaluacion ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                return this.cursosInscritos.get( i ).verificarEvaluacion( evaluacion );
            }
        }
        return false;
    }
    
    @Override
    public void agregarNota( String clave, Nota nota ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                this.cursosInscritos.get( i ).agregarNota( nota );
            }
        }
    }
    
    @Override
    public void mostrarNotas() {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            this.cursosInscritos.get( i ).mostrarNotas();
        }
    }
    
    @Override
    public void reemplazarCurso( String clave, Asignatura a ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                this.mapaCursos.remove( this.cursosInscritos.get( i ).getClave() );
                this.cursosInscritos.set( i, a );
                this.mapaCursos.put( a.getClave(), a );
            }
        }
    }
    
    @Override
    public void eliminarCurso( String clave ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                this.cursosInscritos.remove( i );
                this.mapaCursos.remove( clave );
            }
        }
    }
   
    @Override
    public void mostrarDatosAsignatura( String clave ) {
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( this.cursosInscritos.get( i ).getClave().equals( clave ) ) {
                System.out.println( this.cursosInscritos.get( i ).getNombre() + " (" + this.cursosInscritos.get( i ).getClave() + ")" );
            }
        }
    }
    
    @Override
    public void mostrarAlumnoAsignatura( String clave, int k ) {
        double promedio = 0;
        this.cursoBuscado = this.mapaCursos.get( clave );
        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + getNombre() );
        System.out.println( "     | RUT: " + getRut() );
        System.out.println( "     | EDAD: " + getEdad() );
        if ( !this.cursoBuscado.hayNotas() ) {
            System.out.print( "     | NOTAS: " );
            this.cursoBuscado.mostrarNotas();
            promedio = this.cursoBuscado.calcularPromedio();
            promedio = Math.round( promedio * 10 ) / 10d;
            System.out.println( "     | PROMEDIO: " + promedio );
        } else {
            System.out.println( "     | NOTAS: No hay notas registradas." );
            System.out.println( "     | PROMEDIO: -");
        }
    }
    
    @Override
    public double calcularPromedioAsignatura( String clave ) {
        double promedio = 0;
        this.cursoBuscado = this.mapaCursos.get( clave );
        if ( !this.cursoBuscado.hayNotas() ) {
            promedio = this.cursoBuscado.calcularPromedio();
        } else {
            return 0;
        }
        return promedio;
    }
    
    @Override
    public double calcularPromedioGeneral() {
        int cursosConNotas = 0;
        double promedio = 0;
        
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( !this.cursosInscritos.get( i ).hayNotas() ) {
                cursosConNotas++;
                promedio = promedio + this.cursosInscritos.get( i ).calcularPromedio();
            }
        }
        if ( cursosConNotas != 0 ) {
            promedio = Math.round( ( promedio / cursosConNotas ) * 10 ) / 10d;
            return promedio;
        }
        return 0;
    }
    
    @Override
    public int promediosSobresalientes( int k ) {
        int promediosSobresalientes = 0; 
        double promedio = 0;
        boolean estaEscrito = false;
        
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( !this.cursosInscritos.get( i ).hayNotas() ) {
                promedio = this.cursosInscritos.get( i ).calcularPromedio();
                promedio = Math.round( promedio * 10 ) / 10d;
                if ( promedio >= 6.0 ) {
                    promediosSobresalientes++;
                    if ( !estaEscrito ) {
                        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + getNombre() + " (" + getRut() + ")" );
                        System.out.println( " ------------------------------------------------------------------------");
                        estaEscrito = true;
                    }
                    System.out.println( "     | CURSO: " + this.cursosInscritos.get( i ).getNombre() + " (" + this.cursosInscritos.get( i ).getClave() + ")" );
                    System.out.print( "     | NOTAS: " );
                    this.cursosInscritos.get( i ).mostrarNotas();
                    System.out.println( "     | PROMEDIO: " + promedio );
                    System.out.println( " ------------------------------------------------------------------------");
                }
            }
        }
        
        return promediosSobresalientes;
    }
    
    @Override
    public int cursosEnRiesgo( int k ) {
        int cursosEnRiesgo = 0; 
        double promedio = 0;
        boolean estaEscrito = false;
        
        for ( int i = 0; i < this.cursosInscritos.size(); i++ ) {
            if ( !this.cursosInscritos.get( i ).hayNotas() ) {
                promedio = this.cursosInscritos.get( i ).calcularPromedio();
                promedio = Math.round( promedio * 10 ) / 10d;
                if ( promedio < 4.0 ) {
                    cursosEnRiesgo++;
                    if ( !estaEscrito ) {
                        System.out.println( "  0" + ( k+1 ) + " | NOMBRE: " + getNombre() + " (" + getRut() + ")" );
                        System.out.println( " ------------------------------------------------------------------------");
                        estaEscrito = true;
                    }
                    System.out.println( "     | CURSO: " + this.cursosInscritos.get( i ).getNombre() + " (" + this.cursosInscritos.get( i ).getClave() + ")" );
                    System.out.print( "     | NOTAS: " );
                    this.cursosInscritos.get( i ).mostrarNotas();
                    System.out.println( "     | PROMEDIO: " + promedio );
                    System.out.println( " ------------------------------------------------------------------------");
                }
            }
        }
        
        return cursosEnRiesgo;
    }
    /*
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
    */
    
    public void mostrarProfesorAsignatura( int k ) {
        
    }
    
}