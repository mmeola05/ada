package TEMA1;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class ejercicio5 {
     public static void main(String[] args) {
        final String RUTAFICHERO = "C:\\Users\\marmeoesc\\Documents\\TEMA1\\TEMA1\\ficheros\\";

        GestionArchivos.crearArchivo(RUTAFICHERO, "prueba1.txt");
        GestionArchivos.listarDirectorio(RUTAFICHERO);
        GestionArchivos.verInfo(RUTAFICHERO, "prueba.txt");
    } 
}
