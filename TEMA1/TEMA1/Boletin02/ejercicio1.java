package TEMA1.Boletin02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio1 {

    public static void main(String[] args) {
        procesarDnis("C:\\Users\\marcm\\Documents\\ADA\\TEMA1\\TEMA1\\TEMA1\\Boletin02\\dnis.txt");
    }
    /**
     * Lee un fichero de DNIs, calcula la letra y escribe un nuevo fichero con los DNIs completos.
     * @param nombreFichero
     */
    public static void procesarDnis(String nombreFichero) {
        String nuevoNombre = nombreFichero.replace(".txt", "_conLetras.txt");
        char[] letras = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
         BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoNombre))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String dni = String.format("%08d", Integer.valueOf(linea.trim()));
                char letra = letras[Integer.parseInt(dni) % 23];
                bw.write(dni + letra);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
