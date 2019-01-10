package prog2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import util.SearchTreeMap;

public class TestRemove {

	public static void main(String[] args) {
		TreeMap<String, Integer> java_map = new TreeMap<>();
		SearchTreeMap<String, Integer> my_map = new SearchTreeMap<>();
		
		//data to draw from to create random map entries
		String[] names = {
				"jerry", "paul", "erin", "kevin", "helen",
				"bill", "john", "bob", "rick", "tim",
		};
		
		// create random entries
		List<Map.Entry<String, Integer>> random_entries = new ArrayList<>();
		Random rand = new Random();
		int num_entries = 10;
		String first_key = null;
		for(int i = 0; i < num_entries; i++){
			String name = names[rand.nextInt(names.length)];	// random name
			if(i == 0) first_key = name;
			int value = rand.nextInt(10);
			Integer age = value == 0 ? null : 10 + value;	// random value or null
			random_entries.add(new AbstractMap.SimpleEntry<>(name, age));
		}
		
		//  create fixed entries
		List<Map.Entry<String, Integer>> fixed_entries = new ArrayList<>();
		fixed_entries.add(new AbstractMap.SimpleEntry<>("john", 22));
		fixed_entries.add(new AbstractMap.SimpleEntry<>("helen", null));
		fixed_entries.add(new AbstractMap.SimpleEntry<>("tim", 17));
		fixed_entries.add(new AbstractMap.SimpleEntry<>("rick", 29));
		
		List<Map.Entry<String, Integer>> entries;
		
		//--- choose fixed or random
		//entries = fixed_entries;
		entries = random_entries;
		
		// create the maps from entries chosen
		entries.forEach((entry) -> {
			java_map.put(entry.getKey(), entry.getValue());
			my_map.put(entry.getKey(), entry.getValue());
		});
		
		String toRemove;
		
		Integer value;
		
		//---- choose name to remove
		toRemove = "john";		// fixed choice
		//toRemove = first_key;	// first name of random entries
		//toRemove = names[rand.nextInt(names.length)];	// random name
		
		System.out.println("\n================= java: ");
		System.out.println("before: " + java_map);
		System.out.println("size = " + java_map.size());
		System.out.println("remove: " + toRemove);
		
		value = java_map.remove(toRemove);
		
		System.out.println("\nafter: " + java_map);
		System.out.println("removed value = " + value);
		System.out.println("size = " + java_map.size());
		
		System.out.println("\n\n================= me: ");
		System.out.println("before: " + my_map);
		System.out.println("size = " + my_map.size());
		System.out.println("remove: " + toRemove);
		
		System.out.println("----------------");
		my_map.reverseInorderOutput();
		System.out.println("----------------");
		
		value = my_map.remove(toRemove);
		
		System.out.println("\nafter: " + my_map);
		System.out.println("removed value = " + value);
		System.out.println("size = " + my_map.size());
		
		System.out.println("----------------");
		my_map.reverseInorderOutput();
		System.out.println("----------------");
	}

}
