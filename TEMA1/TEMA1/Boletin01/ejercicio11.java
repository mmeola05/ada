package TEMA1.Boletin01;

import java.io.File;

public class ejercicio11 {
    public static void main(String[] args) {
        File archivo1 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\lineas1.txt");
        File archivo2 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\lineas2.txt");
        File archivoSalida = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\resultadoLineas.txt");

        GestionArchivos.concatLines(archivo1, archivo2, archivoSalida);
    }
}
