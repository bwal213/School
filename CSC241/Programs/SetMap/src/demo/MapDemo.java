package demo;

import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import util.*;

public class MapDemo {

  public static void main(String[] args) {
    Map<String, Integer> people = new TreeMap<>();
//    Map<String, Integer> people = new HashMap<>();
//    Map<String, Integer> people = new LinkedHashMap<>();

//    Map<String, Integer> people = new SearchTreeMap<>();
//    Map<String, Integer> people = new OpenHashMap<>();
    // size
    System.out.println("size=" + people.size());

    // toString
    System.out.println(people);

    String names[] = {
      "jerry", "paul", "erin", "bill", "jerry", "bill", "joe"
    };
    Integer ages[] = {11, 22, 33, null, 18, 33, null};

    // put
    for (int i = 0; i < names.length; ++i) {
      System.out.printf(
          "put(%s,%s) = %s\n", names[i], ages[i], people.put(names[i], ages[i]));
    }

    System.out.println("\nsize=" + people.size());

    // toString
    System.out.println(people);

    // get/containsKey
    System.out.println("\n============ get/containsKey");
    for (String key : new String[]{"erin", "jill", "joe"}) {
      System.out.println("get(" + key + ") = " + people.get(key));
      System.out.println("\tcontainsKey(" + key + ") = " + people.containsKey(key));
    }

    // keySet, values
    System.out.println("\nkeySet= " + people.keySet());
    System.out.println("\nvalues= " + people.values());

    // entrySet iteration
    System.out.println("\n============ iterate using entrySet");
    for (Map.Entry<String, Integer> entry : people.entrySet()) {
      System.out.printf( "entry: %s\t key: %s\tvalue: %s\n", 
          entry, entry.getKey(), entry.getValue()
      );
    }

    // less efficient keySet iteration
    System.out.println("\n============ iterate using keySet");
    for (String key : people.keySet()) {
      System.out.printf("key: %s\tvalue: %s\n", key, people.get(key));
    }

    // remove
    System.out.println("\n============ remove");
    for (String key : new String[]{"erin", "jill", "joe", "erin"}) {
      System.out.printf("remove(%s) = %s\n", key, people.remove(key));
    }
  }
}
