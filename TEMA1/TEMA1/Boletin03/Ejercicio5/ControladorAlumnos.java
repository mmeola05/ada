package TEMA1.Boletin03.Ejercicio5;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonToken;
import org.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ControladorAlumnos {
    public List<Alumno> cargarAlumnos(String rutaArchivo) throws Exception{
        List<Alumno> listaAlumnos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine()) != null){
                sb.append(linea);
            }
        }

        JSONTokener tokener = new JSONTokener(sb.toString());
        JSONArray array = new JSONArray(tokener);
        for(int i = 0; i < array.length(); i++){
            JSONObject obj = array.getJSONObject(i);
            String id = obj.getString("id");
            String nombre = obj.getString("nombre");
            boolean matriculado = obj.getBoolean("matriculado");
            String fechaNacimiento = obj.getString("fechaNacimiento");
            listaAlumnos.add(new Alumno(id, nombre, matriculado, fechaNacimiento));
        }
        return listaAlumnos;
    }
}
