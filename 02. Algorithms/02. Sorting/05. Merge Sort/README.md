### [Video Reference](https://youtu.be/aDX3MFL0tYs)

### Time Complexity: O(nLogn) in all 3 cases - worst, average and best <br> (as merge sort always divides the array into two halves and takes linear time to merge two halves)

![image](https://user-images.githubusercontent.com/64855541/129321997-af851656-92fa-43e6-915a-bd16dd78912c.png)

```java
//initial arguments will be: (arr, 0, n-1)
static void sort(int arr[], int l, int r) {
	// check if there are at least 2 elements in the subarray
	if (l < r) {
		int mid = (l + r) / 2;
		sort(arr, l, mid);
		sort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}
}

static void merge(int arr[], int l, int mid, int r) {
	// create a temporary array to store the merged array
	int temp[] = new int[r - l + 1];

	// create pointers to the original array
	int i = l;
	int j = mid + 1;

	// create pointer to the temporary array
	int k = 0;

	// iterate through the subarrays until one of them gets exhausted
	while (i <= mid && j <= r) {
		if (arr[i] <= arr[j]) {
			temp[k] = arr[i];
			i++;
		} else {
			temp[k] = arr[j];
			j++;
		}
		k++;
	}

	// if the left subarray is exhausted, then copy all the remaining elements from
	// the right subarray to temp
	if (i > mid) {
		while (j <= r) {
			temp[k] = arr[j];
			k++;
			j++;
		}
	}

	// if the right subarray is exhausted, then copy all the remaining elements from
	// the left subarray to temp
	else if (j > r) {
		while (i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
	}

	// copy temp to original array
	for (i = l, k = 0; i <= r; i++, k++)
		arr[i] = temp[k];
}
  ```
