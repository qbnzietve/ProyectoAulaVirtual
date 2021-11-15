package interfaz;

import java.util.*;

public class Asignatura {
    
    private String nombre;
    private String clave;
    private ArrayList<Nota> notas = null;
    private Map<String, Nota> mapaNotas = null;
    //private int hora;
    
    public Asignatura( String nombre, String clave ) {
        this.nombre = nombre;
        this.clave = clave;
        this.notas = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.mapaNotas = new HashMap();
    }
    
    public boolean hayNotas() {
        return this.notas.isEmpty();
    }
    
    public boolean verificarEvaluacion( String evaluacion ) {
        return this.mapaNotas.containsKey( evaluacion );
    }
    
    public void agregarNota( Nota n ) {
        this.notas.add( n );
        this.mapaNotas.put( n.getEvaluacion(), n );
    }
    
    public void mostrarNotas() {
        int i = 0;
        for ( i = 0; i < this.notas.size() - 1; i++ ) {
            System.out.print( this.notas.get( i ).getNota() + " | " );
        }
        System.out.println( this.notas.get( i ).getNota() );
    }
    
    public void mostrarDatosAlumno( int i, String nombre, String rut ) {
        double promedio = 0;
        promedio = this.calcularPromedio();
        ListaCursosAlumno p = new ListaCursosAlumno();
        p.mostrarDatos( i, nombre, rut, this.nombre, this.clave, this.notas, promedio );
    }
    
    public void mostrarDatosProfesor( int i, String nombre, String rut ) {
        ListaCursosProfesor p = new ListaCursosProfesor();
        p.mostrarDatos( i, nombre, rut, this.nombre, this.clave );
    }
    
    public double calcularPromedio() {
        int i = 0;
        double promedio = 0;
        for ( i = 0; i < this.notas.size(); i++ ) {
            promedio = promedio + this.notas.get( i ).getNota();
        }
        promedio = promedio / i;
        return promedio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
