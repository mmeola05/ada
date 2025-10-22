package TEMA1.Boletin03.Ejercicio2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicio2 {
    public static void main(String[] args) {
        ControladorEmpleados controlador = new ControladorEmpleados(
                "TEMA1/TEMA1/Boletin03/Datasets-20251016/empleados.xml");

        List<Empleado> empleados = controlador.getEmpleados();

        Map<String, Integer> contador = new HashMap<>();
        Map<String, Double> acumuladorSalarios = new HashMap<>();

        for (Empleado emp : empleados) {
            String dept = emp.getDepartamento();
            double salario = emp.getSalario();

            contador.put(dept, contador.getOrDefault(dept, 0) + 1);

            acumuladorSalarios.put(dept, acumuladorSalarios.getOrDefault(dept, 0.0) + salario);
        }

        System.out.printf("%-15s | %-13s | %-13s%n", "Departamento", "Nº empleados", "Salario medio");
        System.out.println("-----------------------------------------------------");

        for (String dept : contador.keySet()) {
            int num = contador.get(dept);
            double totalSalario = acumuladorSalarios.get(dept);
            double media = totalSalario / num;

            System.out.printf("%-15s | %-13d | %-13.2f%n", dept, num, media);
        }
    }
}
