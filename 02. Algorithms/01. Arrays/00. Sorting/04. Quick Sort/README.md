### [Video Reference](https://youtu.be/UA_Rmjfj4bw)

### Time Complexity:
> - Average Case: O(nLogn)
![image](https://user-images.githubusercontent.com/64855541/128990812-3f52013f-6c75-45a9-9180-11f10b5cb9d4.png)

> - Worst Case: O(n²)
![image](https://user-images.githubusercontent.com/64855541/128990677-5ad81624-5d39-40e3-b4bc-cb7fa24eb49f.png)

**Although the worst case time complexity of QuickSort is O(n²) which is more than many other sorting algorithms like Merge Sort and Heap Sort, QuickSort is faster in practice. <br> Quick Sort is often the most practical choice for an efficient sorting algorithm in fact sort function given to us by most of the language libraries are implementations of Quick Sort.**

```java
//initial arguments will be: (arr, 0, n-1)
public static void quickSort(int arr[], int l, int h) {
	if (l < h) {
		int pivotIndex = partition(arr, l, h);
		quickSort(arr, l, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, h);
	}
}

private static int partition(int arr[], int l, int h) {
	int pivot = arr[l];
	int i = l;
	int j = h;
	while (i < j) {
		while (i <= h && arr[i] <= pivot)
			i++;
		while (j >= l && arr[j] > pivot)
			j--;
		if (i < j)
			swap(arr, i, j);
	}
	swap(arr, j, l);
	return j;
}
  ```
