// TODO: Sort an Array using Selection Sort Technique
package array.sorting;

import java.util.Arrays;

public class Selection_Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			
			// search for the smallest element
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			
			// swap the smallest element with the element at i
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		System.out.println("Array after Sorting: " + Arrays.toString(arr));
	}
}
