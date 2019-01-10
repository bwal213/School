package demo;
 
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeDemo1 {
  public static void main(String[] args) {
    Comparator<Integer> cmp = new Comparator<Integer>() {
      public int compare(Integer lhs, Integer rhs) {
        String lhs_str = lhs.toString();
        String rhs_str = rhs.toString();
        return lhs_str.compareTo(rhs_str);
      }
    };
    
    Set<String> str_set = new TreeSet<>();
    Set<Integer> int_set = new TreeSet<>();
    Set<Integer> int_set_lex = new TreeSet<>(cmp);
    
//    Set<Integer> int_set_lex = new SearchTreeSet<Integer>(cmp);
//    Set<String> str_set = new SearchTreeSet<>();
//    Set<Integer> int_set = new SearchTreeSet<Integer>();
 
    System.out.println("add \"mm\": " + str_set.add("mm"));
    System.out.println("add \"mm\": " + str_set.add("mm"));
 
    for (String s : new String[]{"aa", "xx", "dd", "pp", "cc", "qq", "nn"}) {
      str_set.add(s);
    }
 
    System.out.println(str_set);
 
    System.out.println("remove \"mm\": " + str_set.remove("mm"));
    System.out.println(str_set);
 
    System.out.println();
 
    int[] samples = {10, 5, 15, 6, 19, 33, 4, 2};
 
    for (int i : samples) {
      int_set.add(i);
    }
    System.out.println("int_set: " + int_set);
 
    for (int i : samples) {
      int_set_lex.add(i);
    }
    System.out.println("int_set_lex: " + int_set_lex);
  }
}