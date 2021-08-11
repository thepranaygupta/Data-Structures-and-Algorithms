// TODO: Sort an Array using Quick Sort Technique
package array.sorting;

import java.util.Arrays;

public class Quick_Sort {

	public static void main(String[] args) {
		int arr[] = { 4, 21, 1, 9, -12, 5, 32, 2, 6 };
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		int n = arr.length;
		quickSort(arr, 0, n - 1);
		System.out.println("Array after Sorting: " + Arrays.toString(arr));
	}

	public static void quickSort(int arr[], int l, int h) {
		if (l < h) {
			int pivotIndex = partition(arr, l, h);
			quickSort(arr, l, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, h);
		}
	}

	private static int partition(int arr[], int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;
		while (i < j) {
			while (i <= h && arr[i] <= pivot)
				i++;
			while (j >= l && arr[j] > pivot)
				j--;
			if (i < j)
				swap(arr, i, j);
		}
		swap(arr, j, l);
		return j;
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
