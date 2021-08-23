// TODO: Search an element in the array using Binary Search Technique
package array.searching;

public class OrderAgnostic_BinarySearch {

	static int orderAgnosticBS(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		// find whether the array is sorted in ascending or descending
		boolean isAsc = arr[start] < arr[end];

		while (start <= end) {
//			int mid = (start + end) / 2; // here (start+end) may exceed the int range
			int mid = start + (end - start) / 2; // same thing, this will never exceed the int range

			if (arr[mid] == target)
				return mid;

			// if the array is sorted in ascending order
			if (isAsc) {
				if (target > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			// if the array is sorted in descending order
			else {
				if (target < arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		// return -1 if the target element does not exist
		return -1;
	}

	public static void main(String[] args) {
//		int[] arr = { 2, 4, 6, 9, 11, 12, 14, 20, 36, 48 }; // ascending order
		int[] arr = { 48, 36, 20, 14, 12, 11, 9, 6, 4, 2 }; // descending order
		int target = 11;

		int ans = orderAgnosticBS(arr, target);
		if (ans == -1)
			System.out.println("Element not Found");
		else
			System.out.println("Element Found at Position " + (ans + 1));
	}
}
