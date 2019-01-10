package demo;
  
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ShowSets {
  public static void main(String[] args) {
    Integer[] I = new Integer[20];
    Random r = new Random();
    for (int n = 0; n < I.length; ++n) {
      I[n] = r.nextInt(50);
    }
 
    Set<Integer> HS = new HashSet<>();
    Set<Integer> LS = new LinkedHashSet<>();
    Set<Integer> TS = new TreeSet<>();
 
    for (Integer n : I) {
      HS.add(n);
      LS.add(n);
      TS.add(n);
    }
    System.out.println("Input Array:    " + Arrays.toString(I));
    System.out.println("HashSet:        " + HS);
    System.out.println("Linked HashSet: " + LS);
    System.out.println("TreeSet:        " + TS);
  } 
}