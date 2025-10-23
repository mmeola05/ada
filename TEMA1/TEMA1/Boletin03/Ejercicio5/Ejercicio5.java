package TEMA1.Boletin03.Ejercicio5;

import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            ControladorAlumnos controlador = new ControladorAlumnos();
            List<Alumno> alumnos = controlador.cargarAlumnos(
                    "TEMA1/TEMA1/Boletin03/Datasets-20251016/alumnos.json"
            );
            System.out.println("LISTADO DE ALUMNOS");
            System.out.println("--------------------------------------------------------------------");
            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar los alumnos: " + e.getMessage());
        }
    }
}
