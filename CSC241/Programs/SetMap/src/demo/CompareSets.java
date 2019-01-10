package demo;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CompareSets {
  public static void main(String[] args) {
    long start_hash = 0;
    long start_sort = 0;
    long end_hash = 0;
    long start_tree = 0;
    long end_tree = 0;
    Set<Integer> TS = null;
 
    final int NUM = 80000;
 
    // do it twice: 
    //   the first time "primes the machinery" and is ignored,
    //   the second time for real.
    for (int i = 0; i < 2; ++i) {
      Integer[] I = new Integer[NUM];
      Random r = new Random();
      for (int n = 0; n < I.length; ++n) {
        I[n] = r.nextInt(NUM);
      }
 
      HashSet<Integer> HS = new HashSet<>();
      TS = new TreeSet<>();
 
      List<Integer> HSL = new ArrayList<>();
 
      start_hash = System.currentTimeMillis();
 
      for (Integer n : Arrays.asList(I)) { // add the integers to the hash set, HS
        HS.add(n);
      }
 
      start_sort = System.currentTimeMillis();
 
      for (Integer n : HS) {  // transfer from the tree set to the list, HSL
        HSL.add(n);
      }
      Collections.sort(HSL);  // sort the list
 
      end_hash = System.currentTimeMillis();
 
      // Now, create the same effect using a TreeSet
 
      start_tree = System.currentTimeMillis();
 
      for (Integer n : Arrays.asList(I)) {  // add the integers to the tree set, TS
        TS.add(n);
      }
 
      end_tree = System.currentTimeMillis();
    }
 
    System.out.println("total: " + NUM);
    System.out.println("total unique: " + TS.size());
    System.out.println("hash: " + (end_hash - start_hash) + "ms");
    System.out.println("\tenter: " + (start_sort - start_hash) + "ms");
    System.out.println("\tsort: " + (end_hash - start_sort) + "ms");
    System.out.println("tree: " + (end_tree - start_tree) + "ms");
  }
}