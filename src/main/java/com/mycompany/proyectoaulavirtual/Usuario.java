package com.mycompany.proyectoaulavirtual;

import java.util.*;

public class Usuario {
    
    private String username;
    private String nombre;
    private String rut;
    private int edad;
    private String contraseña;
    private int rol;
    private int uid;
    
    public Usuario( String username, String nombre, String rut, int edad, String contraseña, int rol ) {
        this.username = username;
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.contraseña = cifrarContraseña( contraseña );
        this.rol = rol;
        this.uid = crearUid( rol );
    }
    
    private String cifrarContraseña( String contraseña ) {
        return contraseña;
    }
    
    private String descifrarContraseña( String contraseña ) {
        return contraseña;
    }
    
    private int crearUid( int rol ) {
        this.uid = rol * 1000000;
        return this.uid;
    }
    
    public String convertirContraseña( String contraseña ) {
        contraseña = cifrarContraseña( contraseña );
        return contraseña;
    }
    
    public String recuperarContraseña( String contraseña ) {
        contraseña = descifrarContraseña( this.contraseña );
        return contraseña;
    }
    
    public void mostrarDatos() {
        System.out.println( "  NOMBRE: " + this.nombre );
        System.out.println( "  RUT: " + this.rut );
        System.out.println( "  EDAD: " + this.edad );
        System.out.println( " -----------------------------------------------------------------------");
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
}
