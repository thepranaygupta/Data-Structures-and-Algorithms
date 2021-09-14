## Sum triangle from array
## https://www.geeksforgeeks.org/sum-triangle-from-array/

### Approach:
+ At each iteration create a new array which contains the Sum of consecutive elements in the array passes as parameter.
+ Make a recursive call and pass the newly created array in the previous step.
+ While back tracking print the array (for printing in reverse order).

```java
// initial arguments: (arr, arr.length)
static void sum(int[] arr, int n) {
	if(n < 1)
		return;
	int temp[] = new int[n-1];
	for(int i = 0; i < n-1; i++) {
		temp[i] = arr[i] + arr[i + 1];
	}
	sum(temp, n - 1);
	System.out.println(Arrays.toString(arr));
}
```
