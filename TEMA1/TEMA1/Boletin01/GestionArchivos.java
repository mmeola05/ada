package TEMA1.Boletin01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionArchivos {

    public static boolean crearArchivo(String directorio, String archivo) {
        File carpeta = new File(directorio);
        if (!carpeta.exists()) {
            System.out.println("El directorio no existe.");
            return false;
        }
        File fichero = new File(carpeta, archivo);
        try {
            if (fichero.createNewFile()) {
                System.out.println("Archivo creado correctamente: " + fichero.getAbsolutePath());
                return true;
            } else {
                System.out.println("El archivo ya existe.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
            return false;
        }
    }

    public static void listarDirectorio(String directorio) {
        File carpeta = new File(directorio);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("El directorio no existe.");
            return;
        }

        File[] lista = carpeta.listFiles();
        if (lista != null) {
            for (File f : lista) {
                System.out.println((f.isDirectory() ? "Directorio: " : "Fichero: ") + f.getName());
            }
        }
    }

    public static void verInfo(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);
        if (!fichero.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Se puede leer: " + (fichero.canRead() ? "Sí" : "No"));
        System.out.println("Se puede escribir: " + (fichero.canWrite() ? "Sí" : "No"));
        System.out.println("Tamaño: " + fichero.length() + " bytes");
        System.out.println("Es directorio: " + (fichero.isDirectory() ? "Sí" : "No"));
        System.out.println("Es archivo: " + (fichero.isFile() ? "Sí" : "No"));
    }

    public static void leerArchivo(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);
        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El archivo no existe o no es un archivo.");
            return;
        }

        try (FileReader lector = new FileReader(fichero); 
        BufferedReader br = new BufferedReader(lector)) {

            String linea;
            System.out.println("Contenido de " + archivo + ":");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void leerHexa(String directorio, String archivo) {
        File fichero = new File(directorio, archivo);
        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El archivo no existe o no es un archivo.");
            return;
        }

        try (FileInputStream fiStream = new FileInputStream(fichero)) {
            int by;
            int contador = 0;

            System.out.println("Contenido hexadecimal de " + archivo + ":");
            while ((by = fiStream.read()) != -1) {
                System.out.printf("%02X ", by);
                contador++;
                if (contador % 10 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static boolean comparar(File f1, File f2) {
        if (!f1.exists() || !f2.exists()) {
            System.out.println("Uno de los archivos no existe.");
            return false;
        }

        if (f1.length() != f2.length()) {
            return false;
        }

        try (FileInputStream fis1 = new FileInputStream(f1);
             FileInputStream fis2 = new FileInputStream(f2)) {

            int b1, b2;
            while ((b1 = fis1.read()) != -1) {
                b2 = fis2.read();
                if (b1 != b2) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("Error archivos: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static void concat(File archivo1, File archivo2, File archivoSalida) {
        try (
                FileReader lector1 = new FileReader(archivo1);
                BufferedReader br1 = new BufferedReader(lector1);
                FileReader lector2 = new FileReader(archivo2);
                BufferedReader br2 = new BufferedReader(lector2);
                FileWriter escritor = new FileWriter(archivoSalida);
                BufferedWriter bw = new BufferedWriter(escritor)) {
            String linea;

            while ((linea = br1.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            while ((linea = br2.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void concatLines(File archivo1, File archivo2, File archivoSalida) {
        try (
                FileReader lector1 = new FileReader(archivo1);
                BufferedReader br1 = new BufferedReader(lector1);
                FileReader lector2 = new FileReader(archivo2);
                BufferedReader br2 = new BufferedReader(lector2);
                FileWriter escritor = new FileWriter(archivoSalida);
                BufferedWriter bw = new BufferedWriter(escritor)) {
            String linea1, linea2;

            while ((linea1 = br1.readLine()) != null | (linea2 = br2.readLine()) != null) {
                if (linea1 == null) {
                    linea1 = "";
                }
                if (linea2 == null) {
                    linea2 = "";
                }
                bw.write(linea1 + linea2);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
