package TEMA1;

import java.io.File;

public class ejercicio9 {
    public static void main(String[] args) {
        File archivo1 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\prueba.txt");
        File archivo2 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\prueba1.txt");

        boolean iguales = GestionArchivos.comparar(archivo1, archivo2);

        if (iguales) {
            System.out.println("Los archivos son iguales.");
        } else {
            System.out.println("Los archivos son diferentes.");
        }
    }
}
