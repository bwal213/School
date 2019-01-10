package demo;
 
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import util.SearchTreeSet;
 
public class TreeDemo2 {
  public static void main(String[] args) {
 
    SortedSet<String> sset = new TreeSet<>();
//    SortedSet<String> sset = new SearchTreeSet<>();
 
    String[] samples = {"aa", "xx", "dd", "pp", "cc", "qq", "nn"};
 
    for (String s : samples) {
      sset.add(s);
    }
 
    System.out.println(sset);
 
    System.out.println("------ SortedSet properties:");
    System.out.println("first= " + sset.first());
    System.out.println("last=  " + sset.last());
    System.out.println("headSet(\"m\")= " + sset.headSet("m"));
    System.out.println("tailSet(\"m\")= " + sset.tailSet("m"));
 
    NavigableSet<String> nset = (NavigableSet<String>) sset;
 
    System.out.println("pollFirst = " + nset.pollFirst());
    System.out.println(nset);
 
    System.out.println("------ NavigableSet properties:");
    System.out.println("ceiling(\"m\") = " + nset.ceiling("m"));
    System.out.println("floor(\"m\")   = " + nset.floor("m"));
  }
}