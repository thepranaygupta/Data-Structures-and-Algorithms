package sets;

import java.util.HashSet;
import java.util.Set;

public class MyHashSet {

	public static void main(String args[]) {

		Set<String> fruits = new HashSet<>();

		fruits.add("Apple");
		fruits.add("Banana");
		System.out.println(fruits.add("Kiwi")); // this will print true as add function will return true
		System.out.println(fruits.add("Banana")); // this will print false as add function will return false
		/*
		 * fruits.add("Banana"); this "Banana" will not be added in the set because Set
		 * does not allow duplicate elements
		 */

		/*
		 * HashSet uses a HashMap internally to implement a Set so the elements will not
		 * retain the order in which they are inserted
		 */
		System.out.println(fruits);

		Set<Integer> numbers = new HashSet<>();
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
