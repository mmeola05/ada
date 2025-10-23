package TEMA1.Boletin03.Ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class ControladorEmpleados {
    private Document doc;

    public ControladorEmpleados(String file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML: " + e.getMessage());
        }
    }

    public List<Empleado> getEmpleados() {
        List<Empleado> lista = new ArrayList<>();

        NodeList nodos = doc.getElementsByTagName("empleado");

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
                Element emp = (Element) nodo;
                String id = emp.getAttribute("id");
                String nombre = emp.getElementsByTagName("nombre").item(0).getTextContent();
                String departamento = emp.getElementsByTagName("departamento").item(0).getTextContent();
                double  salario = Double.parseDouble(emp.getElementsByTagName("salario").item(0).getTextContent());
                String fechaAlta = emp.getElementsByTagName("fechaAlta").item(0).getTextContent();
                lista.add(new Empleado(id, nombre,departamento, salario,fechaAlta));
        }

        return lista;
    }
}
