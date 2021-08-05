package sets;

import java.util.Set;
import java.util.TreeSet;

public class MyTreeSet {

	public static void main(String[] args) {

		Set<String> fruits = new TreeSet<>();

		fruits.add("Kiwi");
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Orange");
		System.out.println(fruits.add("Banana")); // this will print false as add function will return false
		/*
		 * fruits.add("Banana"); this "Banana" will not be added in the set because Set
		 * does not allow duplicate elements
		 */

		/*
		 * TreeSet uses a Tree internally to implement a Set so the elements will be
		 * arranged in a sorted order, int values will be stored in ascending order,
		 * strings will be stored lexicographically
		 */
		System.out.println("FRUIT SET:");
		System.out.println(fruits);

		Set<Integer> numbers = new TreeSet<>();
		numbers.add(5);
		numbers.add(3);
		numbers.add(99);
		numbers.add(6);
		numbers.add(5);
		numbers.add(56);
		numbers.add(8);
		numbers.add(1);

		System.out.println("\nNUMBER SET:");
		System.out.println(numbers);
	}
}
