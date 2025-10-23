package TEMA1.Boletin03.Ejercicio6;

import java.util.List;

public class Alumno
{
    private String id;
    private String nombre;
    private boolean matriculado;
    private String fechaNacimiento;
    private List<Nota> notas;
    public Alumno(String id, String nombre, boolean matriculado, String fechaNacimiento, List<Nota> notas) {
        this.id = id;
        this.nombre = nombre;
        this.matriculado = matriculado;
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public  List<Nota> getNotas() {return notas;}

    public double getNotaMedia() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNota();
        }
        return suma / notas.size();
    }

    public Nota getNotaMaxima(){
        Nota notaMaxima = notas.get(0);
        for (Nota nota : notas) {
            if (nota.getNota() > notaMaxima.getNota()) {
                notaMaxima = nota;
            }
        }
        return notaMaxima;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %-15s | Fecha de nacimiento: %s",
                id, nombre, fechaNacimiento);
    }
}
