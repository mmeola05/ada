package TEMA1.Boletin02;

import java.io.*;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.Scanner;

public class ejercicio3 {

    private static final String FILE = "config.properties";
    private static final String KEY = "password";
    private static final String DEFAULT = "S3cret@";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("**********************");
        System.out.println("1. Validar acceso");
        System.out.println("**********************");
        System.out.print("Elige opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            boolean acceso = validar(sc);
            if (acceso) {
                System.out.println("Acceso concedido");
                menu(sc);
            } else {
                System.out.println("Acceso denegado");
            }
        } else {
            System.out.println("Opción no válida");
        }
    }

    /**
     * Valida contraseña.
     * @return true si acceso correcto, false en caso contrario.
     */
    private static boolean validar(Scanner sc) throws Exception {
        Properties p = cargar();
        String hashGuardado = p.getProperty(KEY);

        if (hashGuardado == null) {
            hashGuardado = hash(DEFAULT);
            p.setProperty(KEY, hashGuardado);
            guardar(p);
            System.out.println("Primera vez: usando contraseña por defecto.");
        }

        System.out.print("Introduce la contraseña: ");
        String input = sc.nextLine();
        String hashInput = hash(input);

        return hashInput.equals(hashGuardado);
    }

    /**
     * Muestra menú después del acceso correcto.
     */
    private static void menu(Scanner sc) throws Exception {
        int op = 0;
        do {
            System.out.println("*************************");
            System.out.println("1. Modificar contraseña");
            System.out.println("2. Salir");
            System.out.println("*************************");
            System.out.print("Elige opción: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                boolean res = cambiar(sc);
                if (res) {
                    System.out.println("Contraseña cambiada con éxito");
                } else {
                    System.out.println("No se pudo cambiar la contraseña");
                }
            } else if (op == 2) {
                System.out.println("Saliendo");
            } else {
                System.out.println("Opción no válida");
            }
        } while (op != 2);
    }

    /**
     * Cambiar contraseña.
     * @return true si cambiada con éxito, false si error (actual incorrecta o nueva inválida).
     */
    private static boolean cambiar(Scanner sc) throws Exception {
        Properties p = cargar();
        String actualHash = p.getProperty(KEY);

        System.out.print("Contraseña actual: ");
        String actualIntroducida = sc.nextLine();
        String hashIntroducida = hash(actualIntroducida);

        if (!hashIntroducida.equals(actualHash)) {
            return false;
        }

        System.out.print("Nueva contraseña: ");
        String nueva = sc.nextLine();

        if (nueva.length() >= 8
                && nueva.matches(".*[a-z].*")
                && nueva.matches(".*[A-Z].*")
                && nueva.matches(".*[0-9].*")
                && nueva.matches(".*[^a-zA-Z0-9].*")) {
            String nuevoHash = hash(nueva);
            p.setProperty(KEY, nuevoHash);
            guardar(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Convierte un texto a hash SHA-1.
     */
    private static String hash(String txt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] bytes = md.digest(txt.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }

        return sb.toString();
    }

    /**
     * Carga archivo config.properties.
     */
    private static Properties cargar() throws IOException {
        Properties p = new Properties();
        File f = new File(FILE);

        if (f.exists()) {
            FileInputStream in = new FileInputStream(f);
            p.load(in);
            in.close();
        }

        return p;
    }

    /**
     * Guarda archivo config.properties.
     */
    private static void guardar(Properties p) throws IOException {
        FileOutputStream out = new FileOutputStream(FILE);
        p.store(out, "Password");
        out.close();
    }
}
