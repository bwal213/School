package demo;

import util.OpenHashSet;

public class OpenHashRemove {

  public static void main(String[] args) {
    OpenHashSet<String> set = new OpenHashSet<>(11, .9F);
 
    String[] strings = {"music", "beer", "afterlife", "wisdom",
      "politics", "theater", "schools", "painting", "fear"};
 
    for (String s : strings) {
      set.add(s);
    }
 
    set.tableOutput();
 
    String[] removals = {"poetry" ,"theater","beer","afterlife"};
 
    for (String remove : removals ) {
      System.out.println("\nto remove: " + remove);
      System.out.println("return value: " + set.remove(remove));
      set.tableOutput();
    }
  }  
}
