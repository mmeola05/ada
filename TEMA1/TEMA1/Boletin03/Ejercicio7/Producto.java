package TEMA1.Boletin03.Ejercicio7;

import java.util.List;

public class Producto {
    private String id;
    private String nombre;
    private int stock;
    private double precio;
    private List<String> tags;
    private Ubicacion ubicacion;

    public Producto(String id, String nombre, int stock, double precio, List<String> tags, Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.tags = tags;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        StringBuilder tagList = new StringBuilder();
        for (String tag : tags) {
            tagList.append(tag).append(", ");
        }
        if (tagList.length() > 0) {
            tagList.setLength(tagList.length() - 2);
        }

        return " Ubicacion: " + ubicacion.toString();
    }

}
