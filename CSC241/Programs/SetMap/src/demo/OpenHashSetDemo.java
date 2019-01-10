package demo;
 
import java.util.Set;
import util.OpenHashSet;

public class OpenHashSetDemo {
  public static void main(String[] args) {
    String[] elements;
    Set<String> set = new OpenHashSet<>(11);
 
    elements = new String[] {
      "games", "blogs", "cartoons", "music", 
      "books", "health", "dining", "sunday", 
    };
    for(String str: elements) {
      System.out.printf("set.add(%s) ", str);
      System.out.printf("= %s\n", set.add(str));
    }
 
    System.out.printf("\nset = %s\n\n", set);
    ((OpenHashSet) set).tableOutput();
    System.out.println();
 
    elements = new String[] {
      "store", "games", "classified", "mobile", "update", "services",
    };
    for(String str: elements) {
      System.out.printf("set.add(%s) ", str);
      System.out.printf("= %s\n", set.add(str));
    }
 
    System.out.printf("\nset = %s\n\n", set);
    ((OpenHashSet) set).tableOutput();
    System.out.println();
 
    elements = new String[] { "store", "mobile", "blogs", "store", };
    for(String str: elements) {
      System.out.println("set.contains("+str+") = " + set.contains(str));
      System.out.println("set.remove("+str+") = " + set.remove(str));
    }
 
    System.out.printf("\nset = %s\n\n", set);
    ((OpenHashSet) set).tableOutput();    
  }
}