// To sort an array in ascending and descending order using Cyclic Sort Algorithm.

import java.util.*;

class CyclicSort {
	public static void main(String[] args) {
		int arr1[] = {3,5,4,1,2};
		int arr2[] = {3,5,4,1,2};
		cyclicSortingAscending(arr1);
		cyclicSortingDescending(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	public static void cyclicSortingAscending(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i]-1 != i) {
				int swap = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = swap;
			}
			else
				i++;
		}
	}
	public static void cyclicSortingDescending(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			if (i+arr[i] != arr.length) {
				int swap = arr[arr.length-arr[i]];
				arr[arr.length-arr[i]] = arr[i];
				arr[i] = swap;
			}
			else
				i++;
		}
	}
}