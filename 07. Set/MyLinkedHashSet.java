package sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class MyLinkedHashSet {

	public static void main(String[] args) {

		Set<String> fruits = new LinkedHashSet<>();

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
		 * LinkedHashSet uses a LinkedList internally to implement a Set so the elements
		 * will retain the order in which they are inserted
		 */
		System.out.println(fruits);

		Set<Integer> numbers = new LinkedHashSet<>();
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
