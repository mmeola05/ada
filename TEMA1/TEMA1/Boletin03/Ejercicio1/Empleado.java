package TEMA1.Boletin03.Ejercicio1;

public class Empleado {
    private String id;
    private String nombre;
    private String departamento;
    private String salario;
    private String fechaAlta;

    public Empleado(String id, String nombre,String departamento, String salario,String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.departamento=departamento;
        this.salario = salario;
        this.fechaAlta=fechaAlta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSalario() {
        return salario;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TEMA1.Boletin03.Ejercicio1.Empleado empleado = (TEMA1.Boletin03.Ejercicio1.Empleado) o;
        return id.equals(empleado.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Departamento: " + departamento+  " | Salario: " + salario+  " | Fecha Alta: " + fechaAlta;
    }
}
