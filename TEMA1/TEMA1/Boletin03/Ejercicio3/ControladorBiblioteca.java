package TEMA1.Boletin03.Ejercicio3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.*;

public class ControladorBiblioteca {
    private List<Libro> listaLibros = new ArrayList<>();

    public void procesarXML(String rutaXML) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(rutaXML);
        doc.getDocumentElement().normalize();

        NodeList nodos = doc.getElementsByTagName("libro");

        for (int i = 0; i < nodos.getLength(); i++) {
            Element libroElem = (Element) nodos.item(i);

            String isbn = libroElem.getAttribute("isbn");
            String titulo = libroElem.getElementsByTagName("titulo").item(0).getTextContent();
            String autor = ((Element) libroElem.getElementsByTagName("autor").item(0))
                    .getElementsByTagName("nombre").item(0).getTextContent();
            int anio = Integer.parseInt(libroElem.getElementsByTagName("anio").item(0).getTextContent());
            boolean disponible = Boolean.parseBoolean(libroElem.getElementsByTagName("disponible").item(0).getTextContent());

            List<String> generos = new ArrayList<>();
            NodeList generosNodos = libroElem.getElementsByTagName("genero");
            for (int j = 0; j < generosNodos.getLength(); j++) {
                generos.add(generosNodos.item(j).getTextContent());
            }

            listaLibros.add(new Libro(isbn, titulo, autor, anio, generos, disponible));
        }
    }

    public List<Libro> getLibros() {
        return listaLibros;
    }

    public Map<String, Integer> contarLibrosPorGenero() {
        Map<String, Integer> contador = new HashMap<>();
        for (Libro libro : listaLibros) {
            for (String genero : libro.getGeneros()) {
                contador.put(genero, contador.getOrDefault(genero, 0) + 1);
            }
        }
        return contador;
    }
}
