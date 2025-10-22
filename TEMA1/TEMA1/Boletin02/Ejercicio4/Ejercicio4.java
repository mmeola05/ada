package TEMA1.Boletin02.Ejercicio4;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio4 {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> usuarios = Controlador.cargarUsuarios();

        while (true) {
            System.out.println("**********************");
            System.out.println("1. Validar acceso");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Salir");
            System.out.println("**********************");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> validarAcceso(sc, usuarios);
                case 2 -> registrarUsuario(sc, usuarios);
                case 3 -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void validarAcceso(Scanner sc, Map<String, String> usuarios) {
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (Controlador.validarAcceso(user, pass, usuarios)) {
            System.out.println("Acceso concedido.");
            menuInterno(sc, usuarios, user);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    private static void registrarUsuario(Scanner sc, Map<String, String> usuarios) {
        System.out.print("Nuevo usuario: ");
        String nuevo = sc.nextLine();

        if (usuarios.containsKey(nuevo)) {
            System.out.println("Ese usuario ya existe.");
            return;
        }

        System.out.print("Contraseña: ");
        String nueva = sc.nextLine();

        if (Controlador.validarContrasena(nueva)) {
            Controlador.registrarUsuario(nuevo, nueva, usuarios);
            System.out.println("Usuario creado correctamente.");
        } else {
            System.out.println("La contraseña no cumple los requisitos.");
        }
    }

    private static void menuInterno(Scanner sc, Map<String, String> usuarios, String user) {
        while (true) {
            System.out.println("*************************");
            System.out.println("1. Modificar contraseña");
            System.out.println("2. Salir");
            System.out.println("*************************");
            System.out.print("Opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Contraseña actual: ");
                String actual = sc.nextLine();

                if (Controlador.validarAcceso(user, actual, usuarios)) {
                    System.out.print("Nueva contraseña: ");
                    String nueva = sc.nextLine();

                    if (Controlador.validarContrasena(nueva)) {
                        Controlador.modificarContrasena(user, nueva, usuarios);
                        System.out.println("Contraseña actualizada.");
                    } else {
                        System.out.println("No cumple los requisitos.");
                    }
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            } else if (op == 2) {
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
