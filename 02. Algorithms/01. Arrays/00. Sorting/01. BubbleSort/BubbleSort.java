// TODO Sort an Array using Bubble-Sort Algorithm
package array.sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					swapped = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if (!swapped)
				break;
		}
		System.out.println("Array after Sorting: " + Arrays.toString(arr));
	}
}
