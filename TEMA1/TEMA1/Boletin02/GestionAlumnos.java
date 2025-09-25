package TEMA1.Boletin02;

import java.io.*;
import java.util.*;

public class GestionAlumnos {

    private File archivo;

    /**
     * Constructor que inicializa el archivo donde se almacenarán los alumnos.
     *
     * @param ruta Ruta del archivo.
     */
    public GestionAlumnos(String ruta) {
        this.archivo = new File(ruta);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    /**
     * Inserta un array de alumnos en el archivo.
     *
     * @param alumnos Array de objetos Alumno a insertar.
     */
    public void insertarAlumnos(Alumno[] alumnos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            for (Alumno a : alumnos) {
                bw.write(a.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al insertar alumnos: " + e.getMessage());
        }
    }

    /**
     * Elimina un alumno del archivo basado en su NIA.
     *
     * @param alumno
     */
    public void eliminarAlumno(Alumno alumno) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.equals(alumno.toString())) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            for (String l : lineas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }

    /**
     * Devuelve una representación en String de todos los alumnos en el archivo.
     *
     * @return String con todos los alumnos.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            sb.append("Error al leer archivo.");
        }
        return sb.toString();
    }
}
