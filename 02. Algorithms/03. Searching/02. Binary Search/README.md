### [Video Reference](https://youtu.be/f6UU7V3szVw)

### Time Complexity: O(log n), where n is the size of the array
![time complexity analysis](https://user-images.githubusercontent.com/64855541/130475812-0709a410-b454-468a-9c7d-507630935b37.png)

```java
//initial arguments will be: (array, element to be searched)
static int binarySearch(int[] arr, int target) {
	int start = 0;
	int end = arr.length - 1;

	while (start <= end) {
//		int mid = (start + end) / 2; // here (start + end) may exceed the int range
		int mid = start + (end - start) / 2; // same thing, this will never exceed the int range
		if (target > arr[mid]) {
			start = mid + 1;
		} else if (target < arr[mid]) {
			end = mid - 1;
		} else {
			return mid;
		}
	}
	// return -1 if the target element does not exist
	return -1;
}
```
