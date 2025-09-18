package TEMA1;

import java.io.File;

public class ejercicio3 {
    public static void main(String[] args) {
        final String RUTACARPETA = "C:\\Users\\marmeoesc\\Documents\\TEMA1\\TEMA1";
        File carpeta = new File(RUTACARPETA);

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return;
        }
        System.out.println("Nombre de la carpeta: " + carpeta.getName());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());
        System.out.println("Se puede leer: " + (carpeta.canRead() ? "Si" : "No"));
        System.out.println("Se puede escribir: " + (carpeta.canWrite() ? "Si" : "No"));

    }
}
