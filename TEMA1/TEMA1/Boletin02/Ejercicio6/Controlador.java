package TEMA1.Boletin02.Ejercicio6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar el cálculo y almacenamiento
 * de números primos en un archivo de texto.
 */
public class Controlador {

    private static final String FILE_NAME = "primos.txt";

    /**
     * Lee todos los números primos guardados en el archivo.
     * Si no existe, devuelve una lista vacía.
     */
    public static List<Integer> leerPrimos() {
        List<Integer> primos = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No existe archivo de primos. Se empezará desde 2.");
            return primos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                primos.add(Integer.parseInt(linea.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return primos;
    }

    /**
     * Genera una cantidad de números primos empezando desde 'inicio'
     * y los añade al archivo.
     */
    public static void generarPrimosDesde(int inicio, int cantidad) {
        int numero = inicio;
        int encontrados = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            while (encontrados < cantidad) {
                if (esPrimo(numero)) {
                    writer.write(numero + "\n");
                    System.out.println("Encontrado primo: " + numero);
                    encontrados++;
                }
                numero++;
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Comprueba si un número es primo.
     */
    private static boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
