### [Video Reference](https://youtu.be/bBQkErahU9c)
### Time Complexity: O(n²)

```java
for (int i = 0; i < n - 1; i++) {
	boolean swapped = false;
	for (int j = 0; j < n - 1 - i; j++) {
		if (arr[j + 1] < arr[j]) {
			swapped = true;
			int temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
		}
	}
	if (!swapped)
		break;
}
```

- **i < n-1 :** According to bubble sort algorithm completion of each pass in outer loop one element will surely move to its sorted position. So, placing n-1 elements in correct position will automatically sort the full array.
- **j < n-1-i :** If it is not n-1 then it will give ArrayIndexOutOfBoundsException. <br>
After execution of outer for loop, each time one element is in its sorted position, so this will exclude the comparison with that element in inner loop.
- **boolean swapped :** If in any iteration it is found that not a single swapping is done, then it means that the array is sorted. So even if more executions are pending in outer loop, it will terminate to reduce the complexity.
