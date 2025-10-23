package TEMA1.Boletin03.Ejercicio5;

public class Alumno
{
    private String id;
    private String nombre;
    private boolean matriculado;
    private String fechaNacimiento;

    public Alumno(String id, String nombre, boolean matriculado, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.matriculado = matriculado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %-15s | Fecha de nacimiento: %s",
                id, nombre, fechaNacimiento);
    }
}
