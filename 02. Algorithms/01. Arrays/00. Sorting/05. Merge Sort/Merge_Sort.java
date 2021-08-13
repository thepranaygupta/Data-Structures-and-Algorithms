// TODO: Sort an Array using Merge Sort Technique
package array.sorting;

import java.util.Arrays;

public class Merge_Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		sort(arr, 0, n - 1);
		System.out.println("Array after Sorting: " + Arrays.toString(arr));
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
		int k = 0;

		// iterate through the subarrays until one of them gets exhausted
		while (i <= mid && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}

		// if the left subarray is exhausted, then copy all the remaining elements from
		// the right subarray to temp
		if (i > mid) {
			while (j <= r) {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}

		// if the right subarray is exhausted, then copy all the remaining elements from
		// the left subarray to temp
		else if (j > r) {
			while (i <= mid) {
				temp[k] = arr[i];
				k++;
				i++;
			}
		}

		// copy temp to original array
		for (i = l, k = 0; i <= r; i++, k++)
			arr[i] = temp[k];
	}
}
