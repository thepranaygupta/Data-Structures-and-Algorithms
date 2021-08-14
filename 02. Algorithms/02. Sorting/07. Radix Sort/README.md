### Prerequisite: [Count Sort](../06.%20Count%20Sort/)
### [Video Reference](https://youtu.be/a5e7RgCdel0)

### Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input (0-9 for decimals, 1-26 for char/strings, etc.)

![image](https://user-images.githubusercontent.com/64855541/129446444-febac3e7-e2a4-4d79-84d6-b672041254be.png)

```java
//initial arguments will be: (arr, exponent(1, 10, 100, 1000....)
static void radixSort(int[] arr, int exp) {
	int[] farr = new int[10];

	// store frequency of each element in farr[] according to their indices
	for (int i = 0; i < arr.length; i++) {
		farr[arr[i] / exp % 10]++;
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
		int index = farr[arr[i] / exp % 10];
		ans[index] = arr[i];
		farr[arr[i] / exp % 10]--;
	}

	// copy the sorted array to original array
	for (int i = 0; i < arr.length; i++)
		arr[i] = ans[i];
}
```
