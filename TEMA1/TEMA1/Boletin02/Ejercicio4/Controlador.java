    package TEMA1.Boletin02.Ejercicio4;

    import com.google.gson.Gson;
    import java.io.*;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;
    import java.util.*;

    public class Controlador {

        private static final String ARCHIVO = "usuarios.json";
        private static final Gson gson = new Gson();

        public static Map<String, String> cargarUsuarios() {
            File file = new File(ARCHIVO);
            if (!file.exists()) {
                Map<String, String> base = new HashMap<>();
                base.put("admin", hashSHA1("S3cret@"));
                guardarUsuarios(base);
                return base;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) sb.append(linea);

                Map<?, ?> mapa = gson.fromJson(sb.toString(), Map.class);
                Map<String, String> usuarios = new HashMap<>();
                for (Map.Entry<?, ?> entry : mapa.entrySet()) {
                    usuarios.put((String) entry.getKey(), (String) entry.getValue());
                }
                return usuarios;
            } catch (IOException e) {
                e.printStackTrace();
                return new HashMap<>();
            }
        }

        public static void guardarUsuarios(Map<String, String> usuarios) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
                writer.write(gson.toJson(usuarios));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static boolean validarAcceso(String usuario, String pass, Map<String, String> usuarios) {
            return usuarios.containsKey(usuario) &&
                    usuarios.get(usuario).equals(hashSHA1(pass));
        }

        public static void registrarUsuario(String usuario, String pass, Map<String, String> usuarios) {
            usuarios.put(usuario, hashSHA1(pass));
            guardarUsuarios(usuarios);
        }

        public static void modificarContrasena(String usuario, String nueva, Map<String, String> usuarios) {
            usuarios.put(usuario, hashSHA1(nueva));
            guardarUsuarios(usuarios);
        }

        public static boolean validarContrasena(String pass) {
            return pass.length() >= 8 &&
                    pass.matches(".*[A-Z].*") &&
                    pass.matches(".*[a-z].*") &&
                    pass.matches(".*\\d.*") &&
                    pass.matches(".*[^A-Za-z0-9].*");
        }

        private static String hashSHA1(String texto) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                byte[] bytes = md.digest(texto.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : bytes) sb.append(String.format("%02x", b));
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

