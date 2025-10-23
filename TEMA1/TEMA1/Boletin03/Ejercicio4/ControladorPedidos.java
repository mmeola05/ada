package TEMA1.Boletin03.Ejercicio4;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.*;

public class ControladorPedidos {
    private List<Pedido> listaPedidos = new ArrayList<>();

    public void cargarPedidos(String rutaXML) throws  ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(rutaXML);
        doc.getDocumentElement().normalize();

        NodeList pedidos = doc.getElementsByTagName("pedido");

        for (int i = 0; i < pedidos.getLength(); i++) {
            Element pedidoElem = (Element) pedidos.item(i);

            String id = pedidoElem.getAttribute("id");
            String nombreCliente = pedidoElem.getElementsByTagName("nombre").item(0).getTextContent();
            String email = pedidoElem.getElementsByTagName("email").item(0).getTextContent();
            String fecha = pedidoElem.getElementsByTagName("fecha").item(0).getTextContent();
            double total = Double.parseDouble(pedidoElem.getElementsByTagName("total").item(0).getTextContent());

            List<Item> items = new ArrayList<>();
            NodeList itemsNodo = pedidoElem.getElementsByTagName("item");

            for (int j = 0; j < itemsNodo.getLength(); j++) {
                Element itemElem = (Element) itemsNodo.item(j);

                String sku = itemElem.getAttribute("sku");
                String descripcion = itemElem.getElementsByTagName("descripcion").item(0).getTextContent();
                int cantidad = Integer.parseInt(itemElem.getElementsByTagName("cantidad").item(0).getTextContent());
                double precioUnitario = Double.parseDouble(
                        itemElem.getElementsByTagName("precioUnitario").item(0).getTextContent());

                items.add(new Item(sku, descripcion, cantidad, precioUnitario));
            }

            listaPedidos.add(new Pedido(id, nombreCliente, email, fecha, items, total));
        }
    }

    public Pedido buscarPedidoPorId(String id) {
        for (Pedido p : listaPedidos) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
