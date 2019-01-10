package demo;

import java.util.Random;
import util.SearchTreeSet;

public class SearchTreeTraversals {

  public static void main(String[] args) {
 
    SearchTreeSet<Integer> tree = new SearchTreeSet<>();
 
    int num_samples = 10;
    Random rand = new Random();
    for (int i = 0; i < num_samples; ++i) {
      tree.add(rand.nextInt(2 * num_samples));
    }
 
    System.out.println("-------- reverse inorder --------");
    tree.reverseInorderOutput();
 
    System.out.println("-------- preorder --------");
    tree.preorderOutput();
 
    System.out.println("-------- postorder --------");
    tree.postorderOutput();
  }  
}
