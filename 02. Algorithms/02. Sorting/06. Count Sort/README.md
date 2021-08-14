### [Video Reference](https://youtu.be/p-OyKUgIrx4)

### Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input (max - min + 1)

#### Counting sort is used when:
- there are smaller integers with multiple counts.
- linear complexity is the need.

```java
//initial arguments will be: (arr, minimum value, maximum value)
static void countSort(int arr[], int min, int max) {
	int range = max - min + 2;
	int[] farr = new int[range];

	// store frequency of each element in farr[] according to their indices
	for (int i = 0; i < arr.length; i++) {
		int index = arr[i] - min;
		farr[index]++;
	}

	// assign indices of sorted array to all the corresponding elements
	// this is important to maintain relative sort among elements with the same value
	for (int i = 0; i < farr.length; i++) {
		if (i == 0)
			farr[i] = farr[i] - 1;
		else
			farr[i] = farr[i] + farr[i - 1];
	}

	// create a temporary array to store the sorted array
	int[] ans = new int[arr.length];
	for (int i = arr.length - 1; i >= 0; i--) {
		int val = arr[i];
		int index = farr[val - min];
		ans[index] = val;
		farr[val - min]--;
	}

	// copy the sorted array to original array
	for (int i = 0; i < arr.length; i++)
		arr[i] = ans[i];
}
```
