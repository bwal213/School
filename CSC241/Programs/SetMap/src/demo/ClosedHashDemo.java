package demo;
 
import java.util.*;
import util.ClosedHashSet;
 
public class ClosedHashDemo {
 
  public static void main(String[] args) {
    Set<String> set = new ClosedHashSet<>(30);
 
    String[] keys = {
      "games", "blogs", "cartoons", "music", "books", "health", "dining",
      "sunday", "store", "classified", "mobile", "update", "services"
    };
 
    for (String key : keys) {
      set.add(key);
    }
 
    System.out.println("keys=" + Arrays.toString(keys));
 
    ((ClosedHashSet) set).tableOutput();
  }
}