package TEMA1.Boletin02;

import java.time.LocalDate;

public class ejercicio2 {

    public static void main(String[] args) {
        GestionAlumnos gestion = new GestionAlumnos("C:\\Users\\marcm\\Documents\\ADA\\TEMA1\\TEMA1\\TEMA1\\Boletin02\\alumnos.txt");

        Alumno a1 = new Alumno("001", "Marc", "Meola", "Escrivá", LocalDate.of(2005, 4, 28));
        Alumno a2 = new Alumno("002", "Guillermo", "Frasquet", "Pons", LocalDate.of(2005, 5, 16));

        gestion.insertarAlumnos(new Alumno[]{a1, a2});
        System.out.println("Después de insertar:");
        System.out.println(gestion);

        gestion.eliminarAlumno(a1);
        System.out.println("Después de eliminar:");
        System.out.println(gestion);
    }
}
