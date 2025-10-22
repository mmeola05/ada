package TEMA1.Boletin03.Ejercicio4;

import java.util.List;

public class Pedido {
    private String id;
    private String cliente;
    private String email;
    private String fecha;
    private List<Item> items;
    private double total;

    public Pedido(String id, String cliente, String email, String fecha, List<Item> items, double total) {
        this.id = id;
        this.cliente = cliente;
        this.email = email;
        this.fecha = fecha;
        this.items = items;
        this.total = total;
    }

    public String getId() { return id; }
    public String getCliente() { return cliente; }
    public String getEmail() { return email; }
    public String getFecha() { return fecha; }
    public List<Item> getItems() { return items; }
    public double getTotal() { return total; }

    public double recalcularTotal() {
        double suma = 0;
        for (Item i : items) {
            suma += i.getSubtotal();
        }
        return suma;
    }
}
