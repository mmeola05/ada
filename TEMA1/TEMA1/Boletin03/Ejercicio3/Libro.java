package TEMA1.Boletin03.Ejercicio3;

import java.util.List;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private List<String> generos;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, int anio, List<String> generos, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.generos = generos;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getGeneros() {
        return generos;
    }

}
