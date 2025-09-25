package TEMA1.Boletin01;

import java.io.File;

public class ejercicio2 {
    public static void main(String[] args) {
        final String RUTACARPETA = "C:\\Users\\marmeoesc\\Documents\\TEMA1\\TEMA1";
        File carpeta = new File(RUTACARPETA);

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return;
        }

        File[] lista = carpeta.listFiles();
        if (lista == null || lista.length == 0) {
            System.out.println("La carpeta está vacía.");
            return;
        }

        for (File f : lista) {
            if (f.isDirectory()) {
                System.out.println("Directorio: " + f.getName());
            } else {
                System.out.println("Fichero: " + f.getName());
            }
        }
    }
}
