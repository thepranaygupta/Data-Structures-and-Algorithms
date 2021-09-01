## 75. Sort Colors || Sort an array of 0s, 1s and 2s
## https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#
## https://leetcode.com/problems/sort-colors/

### Approach 1: Sort the Array, TC = O(N logN)

### Approach 2: Counting Sort, TC = O(N)
> Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array. We traverse the array two times.
```java
class Solution
{
    public static void sort012(int a[], int n)
    {
        int c0 = 0, c1 = 0, c2 = 0;
        for(int ele: a)
        {
            if(ele == 0)
                c0++;
            else if(ele == 1)
                c1++;
            else
                c2++;
        }
        int index = 0;
        for(; index < c0; index++)
            a[index] = 0;
        for(; index < c0+c1; index++)
            a[index] = 1;
        for(; index < c0+c1+c2; index++)
            a[index] = 2;
    }
}
```
### Approach 3: Dutch National Flag Algorithm, TC = O(N)
![Untitled-2021-08-29-1215 (1)](https://user-images.githubusercontent.com/64855541/131707783-d718c0d7-8a77-4aa9-8b0c-c9984d1fa8df.png)

```java
public void sortColors(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    while(mid <= high) {
        if(arr[mid] == 0) {
            swap(arr, low, mid);
            low++;
            mid++;
        }
        else if(arr[mid] == 1) {
            mid++;
        }
        else if(arr[mid] == 2) {
            swap(arr, high, mid);
            high--;
        }
    }
}
```
