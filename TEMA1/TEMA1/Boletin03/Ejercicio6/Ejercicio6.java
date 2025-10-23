package TEMA1.Boletin03.Ejercicio6;

import java.util.List;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            ControladorAlumnos controlador = new ControladorAlumnos();
            List<Alumno> alumnos = controlador.cargarAlumnos(
                    "TEMA1/TEMA1/Boletin03/Datasets-20251016/alumnos.json"
            );
            System.out.println("LISTADO DE ALUMNOS");
            System.out.println("--------------------------------------------------------------------");
            for (Alumno a : alumnos) {
                Nota notaMaxima = a.getNotaMaxima();
                System.out.printf("%-15s | %-50s | (%.1f)\n", a.getNombre(), notaMaxima.getAsignatura(), notaMaxima.getNota());
            }
            System.out.println("\nAlumno con la nota media más alta");
            System.out.println("---------------------------------------");
            Alumno mejorAlumno=alumnos.get(0);
            for (Alumno a : alumnos){
                if (a.getNotaMedia() > mejorAlumno.getNotaMedia()){
                    mejorAlumno=a;
                }
            }
            System.out.printf("%s con una media de %.2f", mejorAlumno.getNombre(), mejorAlumno.getNotaMedia());
        } catch (Exception e) {
            System.out.println("Error al cargar los alumnos: " + e.getMessage());
        }
    }
}
