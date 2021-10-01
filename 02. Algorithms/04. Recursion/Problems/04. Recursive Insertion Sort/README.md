## Recursive Insertion Sort
### https://leetcode.com/problems/sort-an-array/

### Intuition:
- Base Case: If array size is 1 or smaller, return.
- Recursively sort first n-1 elements.
- Insert last element at its correct position in sorted array.

### Time Complexity: O(n²)

```java
class Solution {
    public int[] sortArray(int[] nums)
    {
        insertionSortRecursive(nums, nums.length);
        return nums;
    }
    static void insertionSortRecursive(int arr[], int n)
    {
        if (n <= 1)
            return;
        insertionSortRecursive( arr, n-1 );
        int last = arr[n-1];
        int j = n-2;
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}
```
