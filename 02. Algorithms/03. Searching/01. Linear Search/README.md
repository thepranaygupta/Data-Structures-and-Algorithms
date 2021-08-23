### [Video Reference](https://youtu.be/_HRA37X8N_Q)

### Time Complexity: O(n), where n is the length of the array

```java
//initial arguments will be: (array, element to be searched)
static int linearSearch(int[] arr, int element) {
	if(arr.length == 0)
		return -1;
	
	for(int i = 0; i < arr.length; i++)
	{
		// find the first occurrence of the element and return it's position
		if(arr[i] == element) {
			return i + 1;
		}
	}
	// return -1 if the element is not found in the array
	return -1;
}
```
