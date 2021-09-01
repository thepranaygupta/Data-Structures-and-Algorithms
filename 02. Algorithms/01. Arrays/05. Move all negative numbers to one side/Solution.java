import java.util.Arrays;

public class NegativePositiveArray {

	public static void main(String[] args) {
		int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		int n = arr.length;

		int low = 0;
		int mid = 0;
		while (mid <= n - 1) {
			if (arr[mid] < 0) {
				if (mid != low)
					swap(arr, mid, low);
				low++;
				mid++;
			} else
				mid++;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
