package TEMA1.Boletin03.Ejercicio7;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorInventario {

    private List<Producto> productos=new ArrayList<>();
    public void cargarInventario(String rutaArchivo) throws Exception{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine()) != null){
                sb.append(linea);
            }
        }

        JSONObject json = new JSONObject(sb.toString());
        JSONArray jsonArray = json.getJSONArray("productos");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String id = jsonObject.getString("id");
            String nombre = jsonObject.getString("nombre");
            int stock = jsonObject.getInt("stock");
            double precio=jsonObject.getDouble("precio");

            List<String> tags = new ArrayList<>();
            JSONArray tagsArray = jsonObject.getJSONArray("tags");
            for (int j = 0;j<tagsArray.length();j++){
                tags.add(tagsArray.getString(j));

            }

            JSONObject ubicacionObj = jsonObject.getJSONObject("ubicacion");
            int pasillo = ubicacionObj.getInt("pasillo");
            String estante = ubicacionObj.getString("estante");
            Ubicacion ubicacion = new Ubicacion(pasillo, estante);

            productos.add(new Producto(id, nombre, stock, precio, tags, ubicacion));
        }
    }
    public Producto buscarProductoPorId(String id){
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProductoPorNombre(String nombre){
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
