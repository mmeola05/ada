package TEMA1;
import java.util.*;

public class hashmap {
     public static void main(String[] args) {
        HashMap<String, String> agenda = new HashMap<>();

        agenda.put("Ana", "123456789");

        agenda.put("Luis", "555111222");
        agenda.put("Marta", "444333222");

        System.out.println("Lista inicial:");
        System.out.println(agenda);

        System.out.println("Eliminando a Luis...");
        agenda.remove("Luis");

        agenda.put("Marta", "444333222");

        System.out.println("Lista inicial:");
        System.out.println(agenda);

        System.out.println("Eliminando a Luis...");
        agenda.remove("Luis");
        System.out.println(agenda);

        System.out.println("Vaciando lista...");
        agenda.clear();
        System.out.println(agenda);
    }
}