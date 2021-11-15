package interfaz;

import java.io.*;

public interface ManejoDatos {
    
    public void mostrarDatos( int i );
    public void mostrarDatosVentana( int i );
    public void mostrarDatos();
    public void mostrarDatosVentana();
    public void mostrarDatos( int i, FileWriter fichero ) throws IOException;
    public void mostrarCursos();
    public void mostrarCursosVentana();
    public void mostrarCursos( int rol );
    public void reemplazarCurso( String clave, Asignatura a );
    public void eliminarCurso( String clave );
    public void mostrarDatosAsignatura( String clave );
    public void mostrarAlumnoAsignatura( String clave, int k );
    public void mostrarProfesorAsignatura( int k );
    
}
