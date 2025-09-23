package TEMA1;
import java.util.*;

public class hashmap {
     public static void main(String[] args) {
        HashMap<String, List<String>> agenda = new HashMap<>();

        agenda.put("Ana", new ArrayList<>());
        agenda.get("Ana").add("123456789");
        agenda.get("Ana").add("987654321");

        agenda.put("Luis", new ArrayList<>());
        agenda.get("Luis").add("555111222");

        agenda.put("Marta", new ArrayList<>());
        agenda.get("Marta").add("444333222");
        agenda.get("Marta").add("666777888");

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