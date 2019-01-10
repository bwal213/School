package demo;

import java.util.Random;
import util.AVLTreeSet;

public class AVLDemo {

  public static void main(String[] args) {

    AVLTreeSet<Integer> tree = new AVLTreeSet<>();

    int[] adds;

    System.out.println("============ EXAMPLE\n");

    tree.setShowRotations(true);
    tree.setShowHeights(true);

    adds = new int[]{80, 40, 20, 30, 25, 35};
    for (int i : adds) {
      System.out.println("---------- add " + i);
      tree.add(i);
      tree.reverseInorderOutput();
      System.out.println();
    }

    System.out.println("============ EXAMPLE: sequential\n");

    tree.setShowRotations(true);
    tree.setShowHeights(true);

    tree.clear();

    adds = new int[]{10, 20, 30, 40, 50, 60, 70};
    for (int i : adds) {
      System.out.println("---------- add " + i);
      tree.add(i);
      tree.reverseInorderOutput();
      System.out.println();
    }

    System.out.println("============ EXAMPLE: random\n");

    tree.setShowRotations(false);
    tree.setShowHeights(false);

    tree.clear();

    Random rnd = new Random();
    adds = new int[7];
    for (int i = 0; i < adds.length; ++i) {
      adds[i] = 1 + rnd.nextInt(10);
    }
    for (int i : adds) {
      System.out.println("---------- add " + i);
      tree.add(i);
      tree.reverseInorderOutput();
      System.out.println();
    }
  }
}
