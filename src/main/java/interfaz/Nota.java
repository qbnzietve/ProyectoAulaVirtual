package interfaz;

public class Nota {
    
    private String evaluacion;
    private double nota;
    
    public Nota( String evaluacion, double nota ) {
        this.evaluacion = evaluacion;
        this.nota = nota;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion( String evaluacion ) {
        this.evaluacion = evaluacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota( double nota ) {
        this.nota = nota;
    }
    
}
