package demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RegularLinkedHashMaps {

  public static void main(String[] args) {
    Map<String, Integer> hmap = new HashMap<>();
    Map<String, Integer> lhmap = new LinkedHashMap<>();

    String[] keys = {
      "fashion", "radio", "technology", "television",
      "movies", "business", "wine", "science",
       new String("fashion") // testing key equality
    };

    int[] values = {55, 17, 7, 10, 8, 3, 14, 11, 5};

    int index = 0;
    for (String key : keys) {
      int value = values[index++];
      System.out.println("=====> entry: (" + key + "," + value + ")");
      System.out.println("hmap.put =  " + hmap.put(key, value));
      System.out.println("lhmap.put = " + lhmap.put(key, value));
    }
    System.out.println();

    System.out.println("hmap:  " + hmap);
    System.out.println("lhmap: " + lhmap);
  }
}
