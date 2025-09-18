package TEMA1;

import java.io.File;

public class ejercicio1 {

    public static void main(String[] args){
        final String RUTACARPETA = "C:\\Users\\marmeoesc\\Documents\\TEMA1\\TEMA1";
        File carpeta = new File(RUTACARPETA);

        if(carpeta.exists()){
            System.out.println("La carpeta existe");
            if(carpeta.isDirectory()){
                System.out.println("La carpera es un directorio");
            }else{
                System.out.println("La carpeta no es un directorio");
            }
        }else{
            System.out.println("La carpeta no existe");
        }
    }
}
