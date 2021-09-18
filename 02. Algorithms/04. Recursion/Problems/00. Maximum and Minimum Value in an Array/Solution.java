// TODO: https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/
package recursion;

public class Min_Max_of_Array {

	public static void main(String[] args) {
		int arr[] = { 12, 43, 45, 23, -420, -8, 69, 67, 1 };
		int n = arr.length;
		System.out.println("Minimum Element of Array: " + getMin(arr, 0, n));
		System.out.println("Maximum Element of Array: " + getMax(arr, 0, n));
	}

	static int getMin(int[] arr, int i, int n) {
		if (n == 1)
			return arr[i];
		int min = Math.min(arr[i], getMin(arr, i + 1, n - 1));
		return min;
	}

	static int getMax(int[] arr, int i, int n) {
		if (n == 1)
			return arr[i];
		int max = Math.max(arr[i], getMax(arr, i + 1, n - 1));
		return max;
	}
}
