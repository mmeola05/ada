package TEMA1.Boletin03.Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            ControladorPedidos controlador = new ControladorPedidos();
            controlador.procesarXML("TEMA1/TEMA1/Boletin03/Datasets-20251016/pedidos.xml");

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el ID del pedido: ");
            String idPedido = sc.nextLine();

            Pedido pedido = controlador.buscarPedidoPorId(idPedido);

            if (pedido == null) {
                System.out.println("No se encontró el pedido con ID " + idPedido);
                return;
            }

            System.out.println("\nPedido " + pedido.getId() + " (" + pedido.getFecha() + ")");
            System.out.println("Cliente: " + pedido.getCliente() + "  |  Email: " + pedido.getEmail());

            System.out.printf("%-25s %-10s %-15s %-10s%n", "Descripción", "Cant.", "Precio Unit.", "Subtotal");
            System.out.println("------------------------------------------------------------------");

            for (Item i : pedido.getItems()) {
                System.out.printf("%-25s %-10d %-15.2f %-10.2f%n",
                        i.getDescripcion(), i.getCantidad(), i.getPrecioUnitario(), i.getSubtotal());
            }

            double recalculado = pedido.recalcularTotal();
            double original = pedido.getTotal();

            System.out.println("Total calculado: " + recalculado + " €");
            System.out.println("Total en Original:   " + original + " €");

            if (Math.round(recalculado) == Math.round(original)) {
                System.out.println("El total coincide.");
            } else {
                System.out.println("El total no coincide.");
            }

        } catch (Exception e) {
            System.out.println("Error al procesar el XML: " + e.getMessage());
        }
    }
}
