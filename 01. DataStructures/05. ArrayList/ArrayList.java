package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_List {

	public static void main(String[] args) {
		// creating ArrayList(AL) of name arr

		ArrayList<Integer> arr1 = new ArrayList<>();

		// 1. add(value) - This will keep on adding value in last of array list.
		arr1.add(2);
		arr1.add(7);
		arr1.add(3);
		arr1.add(1);
		arr1.add(7);
		arr1.add(5);
		System.out.println(arr1); // [2, 7, 3, 1, 7, 5]

		// 2. size() - return no. of elements added in AL
		System.out.println(arr1.size());// 6

		// 3. get(index) - return value at particular index
		System.out.println(arr1.get(2));// 3

		// 4. set(index,value) - change value at particular index
		arr1.set(2, 8);
		System.out.println(arr1);// [2, 7, 8, 1, 7, 5]

		// 5. indexOf(value) - return first occurrence index of the particular value if
		// present, else return -1
		System.out.println(arr1.indexOf(7)); // 1
		System.out.println(arr1.indexOf(9)); // -1

		// 6. lastIndexOf(value) - return last occurrence index of the particular value
		// if present, else return -1
		System.out.println(arr1.lastIndexOf(7)); // 4
		System.out.println(arr1.lastIndexOf(9)); // -1

		// 7. remove(index) - remove value at particular index and return the removed
		// value
		System.out.println(arr1.remove(2)); // 8
		System.out.println(arr1); // [2, 7, 1, 7, 5]

		// 8. add(index,value) - add value at particular index. NOTE: Index should lie
		// in range [0 to arr.size()]
		System.out.println(arr1); // before : [2, 7, 1, 7, 5]
		arr1.add(2, 3);
		System.out.println(arr1); // after : [2, 7, 3, 1, 7, 5]

		// 9. addAll(AL) - appends arr1 into new AL and returns true if successfully
		// appended
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(777);
		arr2.add(888);
		arr2.add(999);

		System.out.println(arr1); // [2, 7, 3, 1, 7, 5]
		System.out.println(arr2); // Before : [777, 888, 999]

		System.out.println(arr2.addAll(arr1)); // true

		System.out.println(arr2); // After: [777, 888, 999, 2, 7, 3, 1, 7, 5]

		// 10. addAll(index,AL) - appends arr1 into new AL at particular index and
		// returns true if successfully appended
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(444);
		arr3.add(555);
		arr3.add(666);

		System.out.println(arr1); // [2, 7, 3, 1, 7, 5]
		System.out.println(arr3); // Before : [444, 555, 666]

		System.out.println(arr3.addAll(2, arr1)); // true

		System.out.println(arr3); // After: [444, 555, 2, 7, 3, 1, 7, 5, 666]

		// 11. for loop iteration in ArrayList
		for (int i = 0; i < arr1.size(); i++) {
			System.out.print(arr1.get(i) + " "); // 2 7 3 1 7 5
		}
		System.out.println(); // new line
		// for each loop
		for (int val : arr1) {
			System.out.print(val + " "); // 2 7 3 1 7 5
		}
		System.out.println(); // new line

		// 12. clear() - remove all elements from AL
		arr1.clear();
		arr2.clear();
		arr3.clear();
		System.out.println(arr1); // []
		System.out.println(arr2); // []
		System.out.println(arr3); // []

		// 13. Initialization of new ArrayList with defaultValues.
		ArrayList<Long> arr4 = new ArrayList<>(Arrays.asList(3l, 4l, 1l, 9l, 56l, 7l, 9l, 12l));
	}
}
