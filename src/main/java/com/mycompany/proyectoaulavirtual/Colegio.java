package com.mycompany.proyectoaulavirtual;

import java.util.ArrayList; // Se importa la librería de listas

public class Colegio {
    
    private ArrayList<Alumno> listaAlumnos; // Se crea la listaAlumnos

    public Colegio() {
        this.listaAlumnos = new ArrayList<>();
    }
    
    public void agregarAlumno( Alumno a ) {
        this.listaAlumnos.add( a );
    }
    
    public void mostrarAlumno() {
        for ( int i = 0; i < this.listaAlumnos.size(); i++ ) {
            this.listaAlumnos.get(i).mostrarDatos();
        }
    }
    
}
