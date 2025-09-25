package TEMA1.Boletin01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio8 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debes pasar la ruta del archivo como parámetro.");
            return;
        }

        String rutaArchivo = args[0];
        File fichero = new File(rutaArchivo);

        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El archivo no existe o no es un archivo.");
            return;
        }

        try (FileReader lector = new FileReader(fichero);
                BufferedReader br = new BufferedReader(lector)) {
            String linea;
            System.out.println("Contenido del archivo " + fichero.getName() + ":");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
