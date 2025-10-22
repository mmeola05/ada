package TEMA1.Boletin03.Ejercicio1;
import java.util.List;
public class ejercicio1 {
    public static void main(String[] args) {
        ControladorEmpleados controlador = new ControladorEmpleados("TEMA1/TEMA1/Boletin03/Datasets-20251016/empleados.xml");

        List<Empleado> empleados = controlador.getEmpleados();

        System.out.println("LISTADO DE EMPLEADOS\n");

        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }
}
