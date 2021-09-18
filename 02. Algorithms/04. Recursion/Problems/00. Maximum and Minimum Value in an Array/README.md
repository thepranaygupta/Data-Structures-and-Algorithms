## Program to find the minimum (or maximum) element of an array
## https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/

```java
// initial arguments: (array, 0, array.length)
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
```
