package TEMA1.Boletin02.Ejercicio6;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del ejercicio 6 (sin método main).
 * Encargada de coordinar la lectura, cálculo y guardado de números primos.
 */
public class Ejercicio6 {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        List<Integer> primos = Controlador.leerPrimos();

        int ultimoPrimo = primos.isEmpty() ? 1 : primos.get(primos.size() - 1);
        System.out.println("Último primo encontrado: " + ultimoPrimo);

        System.out.print("¿Cuántos primos nuevos quieres generar? ");
        int cantidadNuevos = sc.nextInt();

        Controlador.generarPrimosDesde(ultimoPrimo + 1, cantidadNuevos);

        System.out.println("\nTotal de primos guardados: "
                + (primos.size() + cantidadNuevos));

        sc.close();
    }
}