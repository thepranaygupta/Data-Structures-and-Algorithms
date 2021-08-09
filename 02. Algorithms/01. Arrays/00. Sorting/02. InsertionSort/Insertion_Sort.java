// TODO Sort an Array using Insertion Sort Technique
package array.sorting;

import java.util.Arrays;

public class Insertion_Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}

		System.out.println("Array after Sorting: " + Arrays.toString(arr));
	}
}
