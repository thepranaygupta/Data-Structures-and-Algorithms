## Find position of an element in a sorted array of infinite numbers <br> (basically without using arr.length)
## https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

## [Video Tutorial](https://youtu.be/W9QJ8HaRvJQ?t=5283)

```java
//initial arguments will be: (array, element to be searched)
static int ans(int[] arr, int target) {
	// first find the range
	// first start with a box of size 2
	int start = 0;
	int end = 1;

	// condition for the target to lie in the range
	while (target > arr[end]) {
		int temp = end + 1; // this is my new start
		// double the box value
		// end = previous end + sizeofbox*2
		end = end + (end - start + 1) * 2;
		start = temp;
	}
	return binarySearch(arr, target, start, end);

}
```
