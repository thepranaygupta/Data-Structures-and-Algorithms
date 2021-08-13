// TODO: Sort an Array using Merge Sort Technique
package array.sorting;

import java.util.Arrays;

public class Merge_Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	static void sort(int arr[], int l, int r) {
		// check if there are at least 2 elements in the subarray
		if (l < r) {
			int mid = (l + r) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	static void merge(int arr[], int l, int mid, int r) {
		// create a temporary array to store the merged array
		int temp[] = new int[r - l + 1];

		// create pointers to the original array
		int i = l;
		int j = mid + 1;

		// create pointer to the temporary array
		int k = l;

		while (i <= mid && j <= r) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
	}
}
