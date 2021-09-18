// TODO: https://www.geeksforgeeks.org/sum-triangle-from-array/

package recursion;

import java.util.Arrays;

public class Sum_triangle_from_array {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		sum(arr, n);
	}

	static void sum(int[] arr, int n) {
		if (n < 1)
			return;
		int temp[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			temp[i] = arr[i] + arr[i + 1];
		}
		sum(temp, n - 1);
		System.out.println(Arrays.toString(arr));
	}

}
