package TEMA1.Boletin03.Ejercicio6;

public class Nota {
    private String asignatura;
    private double nota;

    public Nota(String asignatura, double nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return asignatura + ": " + nota;
    }

}
