package TEMA1.Boletin01;

import java.io.File;

public class ejercicio10 {
    public static void main(String[] args) {
        File archivo1 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\prueba0.txt");
        File archivo2 = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\prueba1.txt");
        File archivoSalida = new File("C:\\Users\\marmeoesc\\Documents\\TEMA1\\ficheros\\resultado.txt");

        GestionArchivos.concat(archivo1, archivo2, archivoSalida);
    }
}
