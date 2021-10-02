package com.mycompany.proyectoaulavirtual;

import java.util.*;

public class Asignatura {
    
    private String nombre;
    private String clave;
    //private int hora;
    //private ArrayList<Nota> notas = null;
    //private Map<String, Nota> mapaNotas = null;
    
    public Asignatura( String nombre, String clave ) {
        this.nombre = nombre;
        this.clave = clave;
        //this.notas = new ArrayList<>();
        //this.mapaNotas = new HashMap();
    }
    /*
    public void registrarNota( Nota n ) {
        this.notas.add( n );
        this.mapaNotas.put( n.getEvaluacion(), n );
    }
    */
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
