### [Video Reference](https://youtu.be/f6UU7V3szVw)

### Time Complexity: O(log n), where n is the size of the array
![time complexity analysis](https://user-images.githubusercontent.com/64855541/130475812-0709a410-b454-468a-9c7d-507630935b37.png)

## Simple Binary Search (when you know in which order the array is sorted):
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

## Order Agnostic Binary Search (when you don't know in which order the array is sorted):

![image](https://user-images.githubusercontent.com/64855541/130511752-f4784faf-250a-4e95-8009-fb718e8e6e09.png)

```java
//initial arguments will be: (array, element to be searched)
static int orderAgnosticBS(int[] arr, int target) {
	int start = 0;
	int end = arr.length - 1;

	// find whether the array is sorted in ascending or descending
	boolean isAsc = arr[start] < arr[end];

	while (start <= end) {
//		int mid = (start + end) / 2; // here (start+end) may exceed the int range
		int mid = start + (end - start) / 2; // same thing, this will never exceed the int range

		if (arr[mid] == target)
			return mid;

		// if the array is sorted in ascending order
		if (isAsc) {
			if (target > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		// if the array is sorted in descending order
		else {
			if (target < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
	// return -1 if the target element does not exist
	return -1;
}
```
