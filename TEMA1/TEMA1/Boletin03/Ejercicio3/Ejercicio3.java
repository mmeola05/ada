package TEMA1.Boletin03.Ejercicio3;

import java.util.List;
import java.util.Map;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            ControladorBiblioteca controlador = new ControladorBiblioteca();
            controlador.procesarXML("TEMA1/TEMA1/Boletin03/Datasets-20251016/biblioteca.xml");

            List<Libro> libros = controlador.getLibros();
            Map<String, Integer> generos = controlador.contarLibrosPorGenero();

            System.out.println("LISTADO DE LIBROS");
            for (Libro libro : libros) {
                System.out.println("- " + libro.getTitulo());
            }

            System.out.printf("%-15s | %-10s%n", "Género", "Cantidad");
            System.out.println("--------------------------------");

            for (String genero : generos.keySet()) {
                System.out.printf("%-15s | %-10d%n", genero, generos.get(genero));
            }

        } catch (Exception e) {
            System.out.println("Error al procesar el XML: " + e.getMessage());
        }
    }
}
