package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.SearchTreeSet;

public class SearchTreeDemo {

  public static void main(String[] args) {
    SearchTreeSet<Integer> tree = new SearchTreeSet<>();
    List<Integer> list = new ArrayList<>();

    int num_samples = 10;

    Random rand = new Random();
    for (int i = 0; i < num_samples; ++i) {
      int n = rand.nextInt(2 * num_samples);
      list.add(n);
      tree.add(n);
    }

    System.out.println("---------------");
    tree.reverseInorderOutput();
    System.out.println("---------------");

    int pos = rand.nextInt(num_samples);
    int num = list.get(pos);

    System.out.println("remove: " + num);
    tree.remove(num);

    System.out.println("---------------");
    tree.reverseInorderOutput();
    System.out.println("---------------");
  }
}
