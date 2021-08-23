// TODO: Search an element in the array using Binary Search Technique
package array.searching;

public class Binary_Search {

	static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
//			int mid = (start + end) / 2; // here (start+end) may exceed the int range
			int mid = start + (end - start) / 2; // same thing, this will never exceed the int range
			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		// return -1 if the target element does not exist
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 9, 11, 12, 14, 20, 36, 48 };
		int target = 11;

		int ans = binarySearch(arr, target);
		if (ans == -1)
			System.out.println("Element not Found");
		else
			System.out.println("Element Found at Position " + (ans + 1));
	}
}
