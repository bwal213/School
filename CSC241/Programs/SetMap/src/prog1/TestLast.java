/**
 * 
 */
package prog1;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

import util.SearchTreeSet;

/**
 * @author Ben Walker
 *
 */
public class TestLast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Integer> java_tree = new TreeSet<>();
		SearchTreeSet<Integer> my_tree = new SearchTreeSet<>();
		
		// create a fixed array of entries
		Integer entries_fixed[] = {
				2, 3, 1
		};
		
		// or make an array of random entries
		int rand_size = 10;
		Random rand = new Random();
		Integer entries_random[] = new Integer[rand_size];
		for(int i = 0; i < rand_size; i++){
			entries_random[i] = rand.nextInt(rand_size);
		}
		
		Integer[] entries = entries_random;  // or = entries_fixed
		
		System.out.println("------------ java:");
		java_tree.addAll(Arrays.asList(entries));
		System.out.println(java_tree);
		System.out.println("size before = " + java_tree.size());
		Integer last = java_tree.last();
		System.out.println("size after = " + java_tree.size());
		System.out.println("last = " + last);
		System.out.println(java_tree);
		
		System.out.println("------------ me:");
		my_tree.addAll(Arrays.asList(entries));
		my_tree.reverseInorderOutput();
		
		System.out.println("size before = " + my_tree.size());
		Integer myLast = my_tree.last();
		System.out.println("size after = " + my_tree.size());
		System.out.println("mylast = " + myLast);
		System.out.println(my_tree);

	}

}
