package TEMA1.Boletin02;
import java.time.LocalDate;

public class Alumno {
    private String nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;

    public Alumno(String nia, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() { return nia; }
    public String getNombre() { return nombre; }
    public String getApellido1() { return apellido1; }
    public String getApellido2() { return apellido2; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public String toString() {
        return nia + "-" + nombre + " " + apellido1 + " " + apellido2 + " / " + fechaNacimiento;
    }
}
