package TEMA1;

import java.io.File;
import java.time.*;
import java.util.Date;

public class ejercicio4 {
    public static void main(String[] args) {
        final String RUTAFICHERO = "C:\\Users\\marcm\\Documents\\ADA\\TEMA1\\TEMA1\\TEMA1\\ficheros\\prueba.txt";
        File fichero = new File(RUTAFICHERO);

         if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("La fichero no existe o no es un fichero.");
            return;
        }
        System.out.println("Nombre del fichero: " + fichero.getName());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Archivo oculto: " + (fichero.isHidden() ? "Sí" : "No"));
        System.out.println("Se puede leer: " + (fichero.canRead() ? "Sí" : "No"));
        System.out.println("Se puede escribir: " + (fichero.canWrite() ? "Sí" : "No"));
        
        Date fechaArchivo =new Date(fichero.lastModified());
        System.out.println("Última modificación: " + fechaArchivo.toString());
        fichero.setLastModified(System.currentTimeMillis());
        Date fechaActualizada =new Date(fichero.lastModified());
        System.out.println("Fecha modificada a: " + fechaActualizada.toString());

        long tamañoBytes = fichero.length();
        double tamañoKB = tamañoBytes / 1024.0;
        double tamañoMB = tamañoKB / 1024.0;

        System.out.println("Tamaño: " + tamañoBytes + " bytes");
        System.out.println("Tamaño: " + tamañoKB + " KB");
        System.out.println("Tamaño: " + tamañoMB + " MB");
    } 
}
