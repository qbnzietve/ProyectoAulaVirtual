package interfaz;

public abstract class Persona implements ManejoDatos {
    
    private String nombre;
    private String rut;
    private int edad;
    
    public Persona( String nombre, String rut, int edad ) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
    }

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

    public void setEdad( int edad ) {
        this.edad = edad;
    }
    
    public abstract void inscribirCurso( Asignatura a );
    public abstract int contarCursos();
    public abstract boolean verificarCurso( String clave );
    public abstract String obtenerNombreCurso( String clave );
    
    //
    public abstract void registrarApoderado( Apoderado a );
    public abstract boolean verificarApoderado();
    public abstract boolean verificarEvaluacion( String clave, String evaluacion );
    public abstract void agregarNota( String clave, Nota nota );
    public abstract void mostrarNotas();
    public abstract double calcularPromedioAsignatura( String clave );
    public abstract double calcularPromedioGeneral();
    public abstract int promediosSobresalientes( int k );
    public abstract int cursosEnRiesgo( int k );
    
}
