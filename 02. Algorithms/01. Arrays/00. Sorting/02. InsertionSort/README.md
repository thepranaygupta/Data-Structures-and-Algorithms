### [Video Reference](https://youtu.be/wWhAhp6PIuQ)

### Time Complexity: O(n²)
#### but less number of swaps than Bubble Sort

```java
for (int i = 1; i < n; i++) {
	int temp = arr[i];
	int j = i - 1;
	while (j >= 0 && arr[j] > temp) {
		arr[j + 1] = arr[j];
		j--;
	}
	arr[j + 1] = temp;
}
```
