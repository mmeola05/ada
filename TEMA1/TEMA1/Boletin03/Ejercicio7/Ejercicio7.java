package TEMA1.Boletin03.Ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args){
        try{
            ControladorInventario controlador=new  ControladorInventario();
            controlador.cargarInventario("TEMA1/TEMA1/Boletin03/Datasets-20251016/inventario.json");
            Scanner sc=new Scanner(System.in);
            System.out.print("Introduce el ID o nombre del producto: ");
            String entrada = sc.nextLine();

            Producto producto = controlador.buscarProductoPorId(entrada);
            if (producto == null) {
                producto = controlador.buscarProductoPorNombre(entrada);
            }

            if (producto != null) {
                System.out.println(producto);
            }else{
                System.out.println("Producto no encontrado");
            }

            sc.close();

        }catch (Exception e){
            System.out.println("Error al cargar el inventario: "+e.getMessage());
        }
    }
}
